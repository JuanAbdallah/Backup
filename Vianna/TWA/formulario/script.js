const nome = document.getElementById('nome');
const senha = document.getElementById('senha');
const cadastro = document.getElementById('cadastro');
const teste = document.querySelectorAll('.teste');


cadastro.addEventListener('submit',event =>{
    event.preventDefault();
    const psw = senha.value;
    if(psw.length < 6){
        alert(`${nome.value} a senha deve ter 6 digitos!`)
    }
    console.log(psw)

   
})

teste.forEach(element => {
    element.addEventListener('click', event=>{
        event.preventDefault();
        element.innerText = 'clicou !'

    })
    
   });

   window.addEventListener('keydown',event =>{
        if(event.key == 'a'){
            document.body.classList.toggle('modo-escuro');
        }
   })