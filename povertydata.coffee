fs = require('fs')
request = require('request')
state = process.argv[2]
path = "http://www.census.gov/did/www/saipe/downloads/estmod14/est14_#{state}.txt"
request.get(path, (error, response, body) ->
  if !error && response.statusCode == 200
    countyDataArray = body.toString().split("\n")
    stateData = new StateData(state, countyDataArray)
    console.log stateData.state
    console.log stateData.highestPercentage()
    console.log stateData.lowestPercentage()
    console.log stateData.findCountyData("King County")
    )

#Constructor for CountyData class, which will represent the following:
# count of people age 0-17 (i.e., children) in poverty (index 8)
# percentage of people age 0-17 (i.e., children) in poverty (index 11)
# median household income (index 20)
# county name (columns 193-238)

class CountyData
  constructor: (@childrenCount, @childrenPercentage, @medianIncome, @countyName) ->

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
    return maxCounty

  lowestPercentage: () ->
    percentageArr = @allCounties.map((county)-> county.childrenPercentage)
    min = Math.min.apply(Math, percentageArr)
    for county in @allCounties
      if county.childrenPercentage == min.toString()
        minCounty = county
    return minCounty

  findCountyData: (countyName) ->
    for county in @allCounties
      if county.countyName == countyName
        foundCounty = county
    if foundCounty
      foundCounty
    else
      "County not found"
