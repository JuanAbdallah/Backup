import java.util.ArrayList;


public class RH
{
    private String nome;   
    private ArrayList <Funcionario> empregados;
    private ArrayList <Funcionario> motoristas;
    private ArrayList <IPericulosidade> funcPericulosidade;
    
    
    public double totalSindicato(){
        double total = 0;
        for(Funcionario f : empregados){
            if(f instanceof ISindicato){
            total += ((Professor)f).contribuicaoSindical();
        }
        }
        return total;
    }
    
    public boolean AposenadoriaEspecial(Funcionario func){
        
        if(func.getIdade() >= 95 && func instanceof Professor){
            return true;
        }
        return false;
    }
    
    public double totalSalarioDoutor(){
        double total = 0;
        for(Funcionario f:empregados){
            
        }
        return 0;
    }
    
    public RH(){
        this("");
    }
    public RH(String nome){
        this.nome = nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
}

