let formulario = document.forms[0];

formulario.addEventListener('submit', (event) =>{
    event.preventDefault();
    let nome = formulario.elements['nome'].value;
    window.alert("nome: " + nome);
})

let botao = document.createElement('button');
botao.setAttribute('type', 'button');
botao.value = "limpar";
botao.innerText = "limpar";

formulario.appendChild(botao);

botao.addEventListener('click', (event)=>{
    formulario.elements['nome'].value = '';
})

