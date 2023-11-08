class Aluno{
#matricula;
constructor(nome,matricula) {
    this.nome = nome;
    this.#matricula = matricula;
}
get matricula(){
    return this.#matricula
}
set matricula(value){
    this.#matricula = value
}

digaOi(){
   
    console.log(`Olá eu sou o(a) ${this.nome}`);
}
}
class Bolsista extends Aluno{
    constructor(nome,matricula,projeto) {
        super(nome,matricula);
        this._projeto = projeto;
    }
    
    imprimeProjeto(){
        console.log('projeto: ' + this.projeto);
    }
    
    get projeto(){
        return this._projeto;
    }
    set projeto(value){
        this._projeto = value;
    }
}

class Pessoa{
    age;
    gender;
    interests;
    #name;
    constructor(firs, last, age, gender, interests){
        this.#name = {
            'first': first,
            'last' : last
        }
        this.age = age;
        this.gender = gender;
        this.interests = interests
    }
    get name(){
        return `${this.name.first} ${this.name.last}`
    }
    set name(value){
        this.#name = value;
    }
}




// Bolsista.prototype = Object.create(Aluno.prototype);
// Object.defineProperty(Bolsista.prototype, 'constructor',
// {
//     value: Bolsista,
//     enumerable: false,
//     writable: true
// });



const maria = new Bolsista("Maria",132456,"IA");

console.log(maria);
