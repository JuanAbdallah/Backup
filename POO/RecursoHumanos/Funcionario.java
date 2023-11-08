
public abstract class Funcionario
{
    private String nome;
    private EEscolaridade escolaridade;
    int idade;
    
    public Funcionario(){
        this("");
    }
    public Funcionario(String nome){
        this.nome = nome;
        this.idade = idade;
    }
    
    public abstract double salario();
    public abstract double decimoTerceiro();
    public double ferias(){
        return salario()/3;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }
    public int getIdade(){
        return idade;
    }
    
    public void setEscolaridade(EEscolaridade escolaridade){
        this.escolaridade = escolaridade;
    }
    public EEscolaridade getEscolaridade(){
        return escolaridade;
    }
}


