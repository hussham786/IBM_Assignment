//Finding upper diagonal matrices values
function upperDiagonalMatrix(...arr: number[][]){
    //console.log(arr.length);
    
    for(let i = 0; i < arr.length; i++){
        //console.log("\t");
        
        for(let j = 0; j < arr.length; j++){
            /* if(i == 2 && j == 1)
            break; */
            
            /* if(i == 1){
                arr.length = 2;
            } else if(i == 2){
                arr.length = 1;
                //console.log("inside i=2");
                
            } else{} */
            
            if((i + j) <= 2)
            console.log(arr[i][j]);
            //console.log("\t");
            
        }
        
        
    }

}

let arrElement = upperDiagonalMatrix([65,33,10],[9,2,1015],[6,31,45]);

//console.log(arrElement);
