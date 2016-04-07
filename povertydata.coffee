fs = require('fs')
path = 'est14_WA.txt'

fs.readFile(path, callback = (err, data) ->
  if err
    console.log err
  else
    console.log data.toString().split("\n")
  )
