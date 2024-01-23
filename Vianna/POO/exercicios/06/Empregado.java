
public class Empregado
{
    private int idade, tempoTrabalho;
    public Empregado(){}
    public Empregado(int idade, int tempoTrabalho){
        this.idade = idade;
        this.tempoTrabalho = tempoTrabalho ;
    }
    
    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    
    public int getTempoTrabalho(){
        return tempoTrabalho;
    }
    public void setTempoTrabalho(int tempoTrabalho){
        this.tempoTrabalho = tempoTrabalho;
    }
    
    public boolean aposentadoria(int idade, int tempoTrabalho){
        if(idade >= 65 || tempoTrabalho >= 30 ||
        (idade >=60 && tempoTrabalho >= 25)){
            return true;
        }
        return false;
    }
}

