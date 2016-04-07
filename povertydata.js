// Generated by CoffeeScript 1.10.0
(function() {
  var CountyData, allCounties, callback, fs, highestPercentage, lowestPercentage, path;

  fs = require('fs');

  path = 'est14_WA.txt';

  CountyData = (function() {
    function CountyData(childrenCount1, childrenPercentage1, medianIncome1, countyName1) {
      this.childrenCount = childrenCount1;
      this.childrenPercentage = childrenPercentage1;
      this.medianIncome = medianIncome1;
      this.countyName = countyName1;
    }

    return CountyData;

  })();

  allCounties = function(countyDataArray) {
    var childrenCount, childrenPercentage, county, countyData, countyName, i, len, medianIncome, ref;
    allCounties = [];
    ref = countyDataArray.slice(1, countyDataArray.length - 1);
    for (i = 0, len = ref.length; i < len; i++) {
      county = ref[i];
      childrenCount = county.slice(49, 57).trim();
      childrenPercentage = county.slice(76, 80).trim();
      medianIncome = county.slice(133, 139).trim();
      countyName = county.slice(193, 238).trim();
      countyData = new CountyData(childrenCount, childrenPercentage, medianIncome, countyName);
      allCounties.push(countyData);
    }
    return allCounties;
  };

  highestPercentage = function(allCounties) {
    var county, i, len, max, maxCounty, percentageArr;
    percentageArr = allCounties.map(function(county) {
      return county.childrenPercentage;
    });
    max = Math.max.apply(Math, percentageArr);
    for (i = 0, len = allCounties.length; i < len; i++) {
      county = allCounties[i];
      if (county.childrenPercentage === max.toString()) {
        maxCounty = county;
      }
    }
    return maxCounty;
  };

  lowestPercentage = function(allCounties) {
    var county, i, len, min, minCounty, percentageArr;
    percentageArr = allCounties.map(function(county) {
      return county.childrenPercentage;
    });
    min = Math.min.apply(Math, percentageArr);
    for (i = 0, len = allCounties.length; i < len; i++) {
      county = allCounties[i];
      if (county.childrenPercentage === min.toString()) {
        minCounty = county;
      }
    }
    return minCounty;
  };

  fs.readFile(path, callback = function(err, data) {
    var a, b, countyData;
    if (err) {
      return console.log(err);
    } else {
      countyData = data.toString().split("\n");
      allCounties = allCounties(countyData);
      a = highestPercentage(allCounties);
      b = lowestPercentage(allCounties);
      return console.log(b);
    }
  });

}).call(this);
