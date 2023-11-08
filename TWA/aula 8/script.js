let nomeTitulo = () => {
    return "Um Elefante incomoda muita gente";
}
let titulo = document.getElementById("titulo1");
titulo.innerText = nomeTitulo();

let paragrafo = document.getElementById("paragrafo1");

let elefante = {
    quantidade: 10,
    conta() {
        let musica = "1 elefante incomoda muita gente\n";
        let incomodam = [`incomodam `];
        for (let i = 2; i <= this.quantidade; i++) {
            incomodam.push(`incomodam `);

            if (i % 2 == 1) {
                musica += `${i} elefantes incomodam muita gente\n`;
            } else {
                musica += `${i} elefantes ${incomodam} muito mais! \n`;
            }
        }

        musica += `\n`;

        for (let i = this.quantidade; i >= 2; i--) {
            if (i % 2 == 0) {
                musica += `${i} elefantes incomodam muita gente\n`;
            } else {
                musica += `${i} elefantes ${incomodam} muito menos! \n`;
            }
            incomodam.pop();
        }

        musica += "1 elefante incomoda muito menos\n";
        return musica;
    }
}
paragrafo.innerText = elefante.conta();