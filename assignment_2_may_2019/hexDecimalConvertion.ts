import * as readline from 'readline';

let valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });

  valFromRuntime.question('Enter a number ', (num) => {
    let divNum: number = parseInt(num) / 16;
    let hexNum: any;
    let hexRem: any;
    let remNum: number = parseInt(num) % 16;
    if(divNum > 9 && divNum < 16){
        if(divNum < 10){
            hexNum = divNum;
        } else if(divNum == 10){
            hexNum = 'A';
        } else if(divNum == 11){
            hexNum = 'B';
        } else if(divNum == 12){
            hexNum = 'C';
        } else if(divNum == 13){
            hexNum = 'D';
        } else if(divNum == 14){
            hexNum = 'E';
        } else if(divNum == 15){
            hexNum = 'F';
        }
    } else if(divNum >= 16){
        divNum = divNum / 16;
    }

    if(remNum > 9 && remNum < 16){
        if(remNum < 10){
            hexRem = remNum;
        } else if(remNum == 10){
            hexRem = 'A';
        } else if(remNum == 11){
            hexRem = 'B';
        } else if(remNum == 12){
            hexRem = 'C';
        } else if(remNum == 13){
            hexRem = 'D';
        } else if(remNum == 14){
            hexRem = 'E';
        } else if(remNum == 15){
            hexRem = 'F';
        }
    } else if(remNum >= 16){
        remNum = remNum % 16;
    }
    console.log("The Hex of the number is: " +(hexRem + hexNum));
    
   
    valFromRuntime.close();
  });