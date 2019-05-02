//Checking whether the key exist in the tuple or not
import * as readline from 'readline';

let valFromRuntime = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });

  valFromRuntime.question('Enter a key value\n', (num) => {
    //Tuple declaration
    let tuppleElem1 : [number, string] = [23, "Hussham"];
    let tuppleElem2 : [number, string] = [73, "Rishab"];
    let tuppleElem3 : [number, string] = [52, "Nandini"];

    if(num == tuppleElem1[num].value){
        console.log(tuppleElem1);
    } else if(num == tuppleElem2[num].value){
        console.log(tuppleElem2);
    } else if(num == tuppleElem3[num].value){
        console.log(tuppleElem3);
    } else {
        console.log("No tuple found!");
        
    }
   
    valFromRuntime.close();
  });