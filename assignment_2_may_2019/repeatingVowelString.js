"use strict";
exports.__esModule = true;
var readline = require("readline");
var valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
valFromRuntime.question('Enter a string ', function (str) {
    var strSplit = str.split('');
    var counter = 0;
    for (var i = 0; i < str.length; i++) {
        if (strSplit[i] == 'a' || strSplit[i] == 'e' || strSplit[i] == 'i' || strSplit[i] == 'o' || strSplit[i] == 'u') {
            counter++;
            if (counter >= 2) {
                console.log("The repeating vowels are: " + strSplit[i]);
            }
        }
    }
    valFromRuntime.close();
});
