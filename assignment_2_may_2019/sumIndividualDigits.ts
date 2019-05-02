import * as readline from 'readline';

let valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });

  valFromRuntime.question('Enter a number ', (num) => {
    let numSplit = num.split('');
    let sum = 0;
    for(let i = 0; i < num.length; i++){
        sum = sum + parseInt(numSplit[i]);
    }
    console.log("The sum of individual digits: "+sum);
    
   
    valFromRuntime.close();
  });