//imagens
let imagem = [
    './assets/images/1.jpg',
    './assets/images/2.jpg',
    './assets/images/3.jpg',
    './assets/images/4.jpg',
    './assets/images/5.jpg',
    './assets/images/6.jpg',
    './assets/images/7.jpg',
    './assets/images/8.jpg',
    './assets/images/9.jpg',
    './assets/images/10.jpg',
    './assets/images/11.jpg',
    './assets/images/12.jpg',
    './assets/images/13.jpg',
    './assets/images/14.jpg',
    './assets/images/15.jpg',
    './assets/images/16.jpg',
    './assets/images/17.jpg',
    './assets/images/18.jpg',
    './assets/images/19.jpg'

];
function aleatorio(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
}



const img = document.querySelector(".imagem");

let vetorImg1 = [];
let vetorImg2 = [];

function iniciarImagens() {
    aleatorio(imagem);
    for (let i = 0; i < 15; i++) {
        const imagemElement = document.createElement('img');
        imagemElement.src = imagem[i];
        vetorImg1[i] = imagem[i];
        imagemElement.className = `img`;
        imagemElement.id = `imagem${i + 1}`;
        imagemElement.alt = `imagem ${i + 1}`;
        img.appendChild(imagemElement);
    }

}

function iniciarImagens2() {
    aleatorio(imagem);
    for (let i = 0; i < 15; i++) {
        const trocaImg = document.querySelector(`#imagem${i + 1}`);
        trocaImg.setAttribute('src', imagem[i]);
        vetorImg2[i] = imagem[i];
    }
}

//botões menu
const butJogo = document.getElementById('butJogo');
butJogo.addEventListener('click', () => {
    window.location.href = 'jogo.html';
});
const butInicial = document.getElementById('butInicial');
butInicial.addEventListener('click', () => {
    window.location.href = 'index.html';
});


//########Cronometro para iniciar o jogo
const minutos = document.querySelector("#minutos");
const segundos = document.querySelector("#segundos");
const milisegundos = document.querySelector("#milisegundos");
const botaoIniciar = document.querySelector("#iniciar");
const cronometro = document.querySelector(".container");
let min = 1, sec = 0, milisec = 0;
let intervalo;
let parar = false;
let start = true;

function iniciarJogo() {
    if (start) {
        iniciarImagens();
        botaoIniciar.remove();
        intervalo = setInterval(() => {
            if (parar == false) {
                milisec -= 10; 
                if (milisec < 0) {
                    milisec = 999;
                    sec--;  
                    if (sec < 0) {
                        sec = 59;
                        min--;  
                        if (min < 0) {
                            min=0;
                            sec=0;
                            milisec=0;
                            parar = true;
                            start = false;
                            iniciarImagens2();
                            removeIMG();
                            clearInterval();
                        }
                    }
                }
                minutos.textContent = formatoCronometro(min);
                segundos.textContent = formatoCronometro(sec);
                milisegundos.textContent = formatoMilisec(milisec);
            }
        }, 10);
    }
}

function formatoCronometro(tempo) {
    return (tempo < 10) ? `0${tempo}` : tempo;
}
function formatoMilisec(tempo) {
    return (tempo < 100) ? `${tempo}`.padStart(3, "0") : tempo;
}
//Jogo
function removeIMG() {
    const imagens = document.querySelectorAll('.img');
    let cont = 0;
    imagens.forEach(aimagem => {
        aimagem.addEventListener('click', event => {
            let errado = true;
            for (let i = 0; i < 15; i++) {
                if (aimagem.getAttribute('src') == vetorImg1[i]) {
                    errado = false;
                    cont++;
                    break;
                }
                else if (aimagem.getAttribute('src') != vetorImg1[i]) {
                    errado = true;
                }
            }
            if (errado) {
                alert(`Fim de jogo\nPontuação: ${cont}/${pontuacaoVitoria()} acertos!`);
                window.location.reload();
            }
            else if(cont==pontuacaoVitoria()){
                alert(`Você achou todas as suas fotos!!!\nPontuação: ${cont}/${pontuacaoVitoria()}!`);
                window.location.href = "../index.html";
            }
            aimagem.remove();
        });
    });
}
function pontuacaoVitoria() {
    let cont = 0;
    vetorImg1.forEach(elemento =>{
        vetorImg2.forEach(elemento2=>{
            if(elemento == elemento2)
                cont++;
        })
    })
    return cont;
}

