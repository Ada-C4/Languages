fs = require('fs')
path = 'est14_WA.txt'

#Constructor for CountyData class, which will represent the following:
# count of people age 0-17 (i.e., children) in poverty (index 8)
# percentage of people age 0-17 (i.e., children) in poverty (index 11)
# median household income (index 20)
# county name (columns 193-238)

class CountyData
  constructor: (@childrenCount, @childrenPercentage, @medianIncome, @countyName) ->

allCounties = (countyDataArray) ->
  allCounties = []
  for county in countyDataArray[1...countyDataArray.length-1]
    childrenCount = county[49..56].trim()
    childrenPercentage = county[76..79].trim()
    medianIncome = county[133..138].trim()
    countyName = county[193..237].trim()
    countyData = new CountyData(childrenCount, childrenPercentage, medianIncome, countyName)
    allCounties.push(countyData)
  return allCounties

highestPercentage = (allCounties) ->
  percentageArr = allCounties.map((county)-> county.childrenPercentage)
  max = Math.max.apply(Math, percentageArr)
  for county in allCounties
    if county.childrenPercentage == max.toString()
      maxCounty = county
  return maxCounty

lowestPercentage = (allCounties) ->
  percentageArr = allCounties.map((county)-> county.childrenPercentage)
  # console.log(percentageArr)
  min = Math.min.apply(Math, percentageArr)
  # console.log(min)
  for county in allCounties
    if county.childrenPercentage == min.toString()
      minCounty = county
  # console.log(minCounty)
  return minCounty

fs.readFile(path, callback = (err, data) ->
  if err
    console.log err
  else
    countyData = data.toString().split("\n")
    allCounties = allCounties(countyData)
    a = highestPercentage(allCounties)
    b = lowestPercentage(allCounties)
    console.log(b)
  )
