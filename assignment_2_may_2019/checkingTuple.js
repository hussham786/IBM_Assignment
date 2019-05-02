"use strict";
exports.__esModule = true;
//Checking whether the key exist in the tuple or not
var readline = require("readline");
var valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
valFromRuntime.question('Enter a key value\n', function (num) {
    //Tuple declaration
    var tuppleElem1 = [23, "Hussham"];
    var tuppleElem2 = [73, "Rishab"];
    var tuppleElem3 = [52, "Nandini"];
    if (num == tuppleElem1[num].value) {
        console.log(tuppleElem1);
    }
    else if (num == tuppleElem2[num].value) {
        console.log(tuppleElem2);
    }
    else if (num == tuppleElem3[num].value) {
        console.log(tuppleElem3);
    }
    else {
        console.log("No tuple found!");
    }
    valFromRuntime.close();
});
