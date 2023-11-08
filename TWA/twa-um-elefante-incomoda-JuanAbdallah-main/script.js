
var elefante = {
    numero: 10,
    conta(){
        
        
        for(var i = 1 ;i <= this.numero; i++){
        
            var letra = '';
            letra += `${i} elefante incomodam muita gente\n`;
            
            i++
            letra += `${i} elefantes `;
            
           
            for(var j = 0; j <= i - 1 ; j ++ ){
                letra += `incomodam,`
                
            }
            letra += " muito mais\n"
            console.log(letra);

        

        }
        for(var i = this.numero ;i >= 0; i--){
            var letra2 = '';
            letra2 += `${i} elefante incomodam muita gente\n`;
            
            i--;
            letra2 += `${i} elefantes `;
            
           
            for(var j = 1; j<= i ; j ++){
                letra2 += `incomodam,`;
                
            }
            letra2 += " muito menos\n"
            console.log(letra2);
            if(i == 3){
                console.log("2 elefantes incomodam muita gente \n1 elefante incomoda muito menos")
                break;
            }

        }
       
    }
    }

    

elefante.conta();