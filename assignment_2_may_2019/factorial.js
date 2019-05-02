"use strict";
exports.__esModule = true;
//Displaying factorial of a given number
var readline = require("readline");
var valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
valFromRuntime.question('Enter a number\n', function (num) {
    var factVal = 1;
    for (var i = parseInt(num); i >= 1; i--) {
        factVal = factVal * i;
    }
    console.log(factVal);
    valFromRuntime.close();
});
