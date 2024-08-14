import java.util.ArrayList;

public class Cliente
{
    private String nome, cpf;
    private ArrayList<Conta> minhasContas;
    
    public Cliente(){
        this("","");
    }
    public Cliente(String nome){
        this(nome,"");
    }
    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        minhasContas = new ArrayList<>();
    }
    
    
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public ArrayList<Conta> getMinhasContas(){
        return minhasContas;
    }    
    public void addConta(Conta c){
        minhasContas.add(c);
    }
    
    public double saldoContas(){
        double soma = 0;
        for(Conta c: minhasContas){
            //System.out.println(" --> "+c.getBanco().getNome() )
            //System.out.println(" --> "+c.getBanco().getContas().size() )
            soma += c.getSaldo();
        }
        return soma;
    }
}
