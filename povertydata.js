// Generated by CoffeeScript 1.10.0
(function() {
  var CountyData, StateData, path, request, state;

  request = require('request');

  state = process.argv[2];

  if (state === void 0) {
    console.log("\n\nWelcome to the US Poverty Data Portal\n\n To retrieve poverty data for a state, pass in the two letter state abbreviation as the first argument when running the program\n example:  node povertydata.js \"WA\" \n\n To retrieve poverty data for a particular county, pass in the county name as the second argument when running the program\n example:  node povertydata.js \"WA\" \"King\" \n\n");
  }

  path = "http://www.census.gov/did/www/saipe/downloads/estmod14/est14_" + state + ".txt";

  request.get(path, function(error, response, body) {
    var county, countyDataArray, stateData;
    if (!error && response.statusCode === 200) {
      countyDataArray = body.toString().split("\n");
      stateData = new StateData(state, countyDataArray);
      county = process.argv[3];
      console.log("\nSTATE POVERTY DATA FOR " + stateData.state + "\n");
      if (county === void 0) {
        stateData.highestPercentage();
        stateData.lowestPercentage();
        return console.log("To learn more about a specific county, pass in the county name as a second argument when running the program again\n\n\n");
      } else {
        return stateData.findCountyData(county);
      }
    } else {
      return console.log("We could not find data for " + state + ". Please try again.");
    }
  });

  CountyData = (function() {
    function CountyData(childrenCount1, childrenPercentage1, medianIncome1, countyName1) {
      this.childrenCount = childrenCount1;
      this.childrenPercentage = childrenPercentage1;
      this.medianIncome = medianIncome1;
      this.countyName = countyName1;
    }

    CountyData.prototype.printData = function() {
      return console.log(" " + this.countyName + "\n Percentage of Children in Poverty: " + this.childrenPercentage + "%\n Number of Children in Poverty: " + this.childrenCount + "\n Median Household Income: " + this.medianIncome + "\n");
    };

    return CountyData;

  })();

  StateData = (function() {
    var createAllCounties;

    function StateData(state1, countyDataArray) {
      this.state = state1;
      this.allCounties = createAllCounties(countyDataArray);
    }

    createAllCounties = function(countyDataArray) {
      var allCounties, childrenCount, childrenPercentage, county, countyData, countyName, i, len, medianIncome, ref;
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

    StateData.prototype.highestPercentage = function() {
      var county, i, len, max, maxCounty, percentageArr, ref;
      percentageArr = this.allCounties.map(function(county) {
        return county.childrenPercentage;
      });
      max = Math.max.apply(Math, percentageArr);
      ref = this.allCounties;
      for (i = 0, len = ref.length; i < len; i++) {
        county = ref[i];
        if (county.childrenPercentage === max.toString()) {
          maxCounty = county;
        }
      }
      console.log("County with highest percentage of childhood poverty:");
      maxCounty.printData();
      return maxCounty;
    };

    StateData.prototype.lowestPercentage = function() {
      var county, i, len, min, minCounty, percentageArr, ref;
      percentageArr = this.allCounties.map(function(county) {
        return county.childrenPercentage;
      });
      min = Math.min.apply(Math, percentageArr);
      ref = this.allCounties;
      for (i = 0, len = ref.length; i < len; i++) {
        county = ref[i];
        if (county.childrenPercentage === min.toString()) {
          minCounty = county;
        }
      }
      console.log("County with the lowest percentage of childhood poverty:");
      minCounty.printData();
      return minCounty;
    };

    StateData.prototype.findCountyData = function(countyName) {
      var county, foundCounty, i, j, len, len1, ref, ref1, results, thisCountyName;
      countyName = countyName.replace(" County", "");
      ref = this.allCounties;
      for (i = 0, len = ref.length; i < len; i++) {
        county = ref[i];
        thisCountyName = county.countyName.replace(" County", "");
        if (thisCountyName === countyName || thisCountyName.toLowerCase() === countyName || thisCountyName.toUpperCase() === countyName) {
          foundCounty = county;
        }
      }
      if (foundCounty) {
        console.log("Data for " + foundCounty.countyName + ":");
        return console.log(foundCounty.printData());
      } else {
        console.log(countyName + " County not found\nPlease select one of the counties below and pass in as a second argument when running the program");
        ref1 = this.allCounties;
        results = [];
        for (j = 0, len1 = ref1.length; j < len1; j++) {
          county = ref1[j];
          results.push(console.log(county.countyName));
        }
        return results;
      }
    };

    return StateData;

  })();

}).call(this);
