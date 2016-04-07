# fs = require('fs')
request = require('request')
state = process.argv[2]
if state == undefined
  console.log "\n\nWelcome to the US Poverty Data Portal\n\n
              To retrieve poverty data for a state, pass in the two letter state abbreviation as the first argument when running the program\n
              example:  node povertydata.js \"WA\" \n\n
              To retrieve poverty data for a particular county, pass in the county name as the second argument when running the program\n
              example:  node povertydata.js \"WA\" \"King\" \n\n"
path = "http://www.census.gov/did/www/saipe/downloads/estmod14/est14_#{state}.txt"
request.get(path, (error, response, body) ->
  if !error && response.statusCode == 200
    countyDataArray = body.toString().split("\n")
    stateData = new StateData(state, countyDataArray)
    county = process.argv[3]
    console.log "\nSTATE POVERTY DATA FOR #{stateData.state}\n"
    if county == undefined
      stateData.highestPercentage()
      stateData.lowestPercentage()
      console.log "To learn more about a specific county, pass in the county name as a second argument when running the program again\n\n\n"
    else
     stateData.findCountyData(county)
  else
    console.log "We could not find data for #{state}. Please try again."
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
    else
      console.log "#{countyName} County not found\nPlease select one of the counties below and pass in as a second argument when running the program"
      for county in @allCounties
        console.log county.countyName
