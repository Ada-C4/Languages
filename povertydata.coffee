fs = require('fs')
path = 'est14_WA.txt'

fs.readFile(path, callback = (err, data) ->
  if err
    console.log err
  else
    console.log data.toString().split("\n")
  )

# count of people age 0-17 (i.e., children) in poverty (index 8)
# percentage of people age 0-17 (i.e., children) in poverty (index 11)
# median household income (index 20)
# county name (columns 193-238)

class CountyData
  constructor: (@childrenCount, @childrenPercentage, @medianIncome, @countyName) ->
