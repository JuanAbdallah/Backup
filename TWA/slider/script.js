let imagens = [
    './assets/images/download.jpeg',
    './assets/images/2.jpeg',
    './assets/images/3.jpeg',
    './assets/images/4.jpg'
];

let atual = 0
const slide = document.getElementById('slide');
slide.setAttribute('src', imagens[atual]);

function avancar() {
    if (atual == imagens.length) {
        atual = 0;
    }
    atual++
    slide.setAttribute('src', imagens[atual]);
}
function voltar() {
    atual--;
    if (atual == -1) {
        atual = imagens.length - 1;
    }
    slide.setAttribute('src', imagens[atual]);
}
const Avancar = document.getElementById('linkAvancar');
const Voltar = document.getElementById('linkVoltar');

Avancar.addEventListener('click', (event) => {
    event.preventDefault();
    if (atual == imagens.length) {
        atual = 0;
    }
    atual++
    slide.setAttribute('src', imagens[atual]);
});
Voltar.addEventListener('click', (event) => {
    event.preventDefault();
    atual--;
    if (atual == -1) {
        atual = imagens.length - 1;
    }
    slide.setAttribute('src', imagens[atual]);
});


