//Displaying factorial of a given number
import * as readline from 'readline';
let valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });

  valFromRuntime.question('Enter a number\n', (num) => {
    let factVal = 1;
    for(let i:number = parseInt(num); i >= 1; i--){
        factVal = factVal * i;
    }

   console.log(factVal);
   
    valFromRuntime.close();
  });