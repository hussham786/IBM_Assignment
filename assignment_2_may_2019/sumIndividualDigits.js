"use strict";
exports.__esModule = true;
var readline = require("readline");
var valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
valFromRuntime.question('Enter a number ', function (num) {
    var numSplit = num.split('');
    var sum = 0;
    for (var i = 0; i < num.length; i++) {
        sum = sum + parseInt(numSplit[i]);
    }
    console.log("The sum of individual digits: " + sum);
    valFromRuntime.close();
});
