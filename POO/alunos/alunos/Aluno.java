

public class Aluno
{
    //Atributos
    String nome;
    double nota;
    
    //Metodo Construtor
    //mesmo nome da classe
    //nao tem retorno
    Aluno(String vNome, double vNota){
        nome = vNome;
        nota = vNota;
    }
    
    
    //Metodos
    boolean isAprovado()
    {
        if(nota >= 7)
            return true;
        return false;
    }
    
}
