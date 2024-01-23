
const linkLi = document.querySelector('li');
const corpo = document.querySelector('body');

const primeiroLi = document.querySelector('nav ul li');



const menu = document.querySelector('nav');

const paragrafo = menu.querySelector('p');

const conteudo = document.getElementById('conteudo');

const superior =  primeiroLi.children[0];
const inferior = primeiroLi.children[2];

const ultimoParagrafo = document.createElement('p');
ultimoParagrafo.innerText = "Ultimo texto";

conteudo.appendChild(ultimoParagrafo);