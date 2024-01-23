let titulo = document.getElementById("titulo1");
titulo.innerText = "Novo título";

let paragrafo = document.getElementById("paragrafo1");
let mariana = {
    quantidade: 10,
    conta(){
        let letra = '';
        let contagem = [];
        let i = 1;
        while ( i <= this.quantidade){
            contagem.push(` é ${i} `);
            letra += 
            `Mariana conta ${i} \n`+
            `Mariana conta ${i}: ${contagem}, é!\n`;
            letra += `Ana, viva a Mariana, viva a Mariana \n\n`;
            i++;
        };
        return letra;
    }
};
paragrafo.innerText = mariana.conta();

getElementsByTagName(p);