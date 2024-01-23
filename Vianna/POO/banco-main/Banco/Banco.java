import java.util.ArrayList;

public class Banco
{
    private String nome;
    private ArrayList<Conta> contas;
    
    public Banco(){   
        contas = new ArrayList<>();     
    }
    public Banco(String nome){
        this.nome = nome;
        contas = new ArrayList<>();
    }
    
    public double saldoContas(){
        double soma = 0;
        for(Conta c: contas){
            soma += c.getSaldo();
        }
        return soma;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public ArrayList<Conta> getContas(){
        return contas;
    }    
    public void addConta(Conta c){
        contas.add(c);
    }
    
    
}
