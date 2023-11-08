
const casas = document.querySelectorAll('.casa');
let i = 0;
casas.forEach(casa => {
    casa.addEventListener('click', event => {
        if (event.target.innerText == '') {
            if (i % 2 == 0) {
                event.target.innerText = 'X';
            } else {
                event.target.innerText = 'O';
            }
            i++;
        }
    })
})
function verificaVitoria() {
  
    
}