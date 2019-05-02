import * as readline from 'readline';

let valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });

  valFromRuntime.question('Enter a string ', (str) => {
    let strSplit = str.split('');
    var counter = 0;
    for(let i = 0; i < str.length; i++){
        if(strSplit[i] == 'a' || strSplit[i] == 'e' || strSplit[i] == 'i' || strSplit[i] == 'o' || strSplit[i] == 'u'){
            counter++;
            if(counter >= 2){
                console.log("The repeating vowels are: " + strSplit[i]);
                
            }
        }

    }
    
   
    valFromRuntime.close();
  });