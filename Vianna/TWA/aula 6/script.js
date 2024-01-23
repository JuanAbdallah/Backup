// var aluno = {
//     nome: "Joãozinho",
//     nota: 8.0,
//     matricula: 123456,
//     frequencia: 0.9,
//     aprovado(){
//         if(this.nota >= 6 && this.frequencia >= 07){
//             return "Aluno aprovado";
//         }else{
//             return "aluno reprovado";
//         }
//     }
// };

// console.log(aluno);

// aluno.telefone = "(32) 94442-9345"

// var joao = {
//     nome: "Joãozinho",
//     nota: 8.0,
//     matricula: 123456,
//     frequencia: 0.9,
// };

// var maria = {
//     nome: "Maria",
//     nota: 8.0,
//     matricula: 123457,
//     frequencia: 0.9,
// };
// var vitor = {
//     nome: "Vitor",
//     nota: 8.0,
//     matricula: 123458,
//     frequencia: 0.9,
// };
// alunos = [joao, maria];
// alunos.push(vitor);         //adicona o elemento no array

// //console.log(alunos.pop());  //remove os elementos do array

// for(let i = 0; i < alunos.length ; i++){
//     console.log(alunos[i].nome);
// }


// Crie o objeto Mariana, que tem o atributo numero e o metodo conta
// O metodo conta deve contar até o valor de numero e exibir a letra
// da música

// https://www.galinhapintadinha.com.br/musicas/letras/dvd-galinha-pintadinha-vol-1/mariana/
// var mariana = {
//     numero: 5,

//     conta() {
//        var letra = '';
//        var contagem = [];
//        for ( var i = 1; i <= this.numero; i++){
//         contagem.push(`é ${i}`)
//         letra +=
//         `Mariana conta ${i} \n` +
//         `Mariana conta ${i}:${contagem} `

//         letra += ` é! \n `
//         letra += `Ana, viva a Marian, viva a Mariana\n\n` 
//        } 
//        console.log(letra);


//     }
// };

// mariana.conta();

var dados = [1, 2, 3, 4, 5, 6];
// do {
//     dados.pop(0);
//     console.log(dados);
// } while (dados.length > 0);

function imprimirItem(item) {
    console.log(item)
        
}
dados.forEach(imprimirItem);