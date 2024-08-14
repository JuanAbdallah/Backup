const botaoAdd = document.getElementById("add");
const telefones = document.getElementById('telefones')

botaoAdd.addEventListener('click', event=>{
    const novoTelefone = document.createElement('input');
    novoTelefone.setAttribute('type','text');
    telefones.insertBefore(novoTelefone,botaoAdd)
    novoTelefone.outerHTML += "<br>"
});