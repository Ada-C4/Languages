# fs = require('fs')
request = require('request')
state = process.argv[2]
path = "http://www.census.gov/did/www/saipe/downloads/estmod14/est14_#{state}.txt"
request.get(path, (error, response, body) ->
  if !error && response.statusCode == 200
    countyDataArray = body.toString().split("\n")
    stateData = new StateData(state, countyDataArray)
    county = process.argv[3]
    console.log "\nSTATE POVERTY DATA FOR #{stateData.state}\n"
    stateData.highestPercentage()
    stateData.lowestPercentage()
    stateData.findCountyData(county)
    )

#Constructor for CountyData class, which will represent the following:
# count of people age 0-17 (i.e., children) in poverty (index 8)
# percentage of people age 0-17 (i.e., children) in poverty (index 11)
# median household income (index 20)
# county name (columns 193-238)

class CountyData
  constructor: (@childrenCount, @childrenPercentage, @medianIncome, @countyName) ->

  printData: () ->
    console.log " #{@countyName}\n
    Percentage of Children in Poverty: #{@childrenPercentage}%\n
    Number of Children in Poverty: #{@childrenCount}\n
    Median Household Income: #{@medianIncome}\n"

class StateData
  constructor: (@state, countyDataArray) ->
    @allCounties = createAllCounties(countyDataArray)

  createAllCounties = (countyDataArray) ->
    allCounties = []
    for county in countyDataArray[1...countyDataArray.length-1]
      childrenCount = county[49..56].trim()
      childrenPercentage = county[76..79].trim()
      medianIncome = county[133..138].trim()
      countyName = county[193..237].trim()
      countyData = new CountyData(childrenCount, childrenPercentage, medianIncome, countyName)
      allCounties.push(countyData)
    return allCounties

  highestPercentage: () ->
    percentageArr = @allCounties.map((county)-> county.childrenPercentage)
    max = Math.max.apply(Math, percentageArr)
    for county in @allCounties
      if county.childrenPercentage == max.toString()
        maxCounty = county
    console.log "County with highest percentage of childhood poverty:"
    maxCounty.printData()
    return maxCounty


  lowestPercentage: () ->
    percentageArr = @allCounties.map((county)-> county.childrenPercentage)
    min = Math.min.apply(Math, percentageArr)
    for county in @allCounties
      if county.childrenPercentage == min.toString()
        minCounty = county
    console.log "County with the lowest percentage of childhood poverty:"
    minCounty.printData()
    return minCounty

  findCountyData: (countyName) ->
    countyName = countyName.replace(" County", "")
    for county in @allCounties
      thisCountyName = county.countyName.replace(" County", "")
      if thisCountyName == countyName || thisCountyName.toLowerCase() == countyName || thisCountyName.toUpperCase() == countyName
        foundCounty = county
    if foundCounty
      console.log "Data for #{foundCounty.countyName}:"
      console.log foundCounty.printData()
      return foundCounty
    else
      console.log "County not found"
