
import java.util.ArrayList;
public class Empresa
{
    private String nome;
    private ArrayList<Funcionario> funcionarios;
    
    public Empresa(){
        nome = "";
        funcionarios = new ArrayList<Funcionario>();
    }
    public Empresa(String nome){
        this.nome = nome;
        funcionarios = new ArrayList<>();
        //pegar o nome do primeiro funcionario
        //funcionario2.getNome()
    }
    public double totalPagamento(){
        double soma = 0;
        for(Funcionario f: funcionarios){
            //if ( f != null)
            soma=+ f.salarioLiquido();
        }
        return soma;
    }
    public ArrayList<Funcionario> getFuncionarios(){
        return funcionarios;
    }
   
    public void addFuncionarios(Funcionario func){
        funcionarios.add(func);
    
    }
    public void removeFuncionarios(int pos,Funcionario func){
        if( pos >= 0 && pos <= funcionarios.size() -1){
        funcionarios.remove(pos);
    }
}
    public Funcionario searchFuncionario(String nome){
        for(int i = 0; i > funcionarios.size(); i++){
            if (nome.equals(funcionarios.get(i).getNome())){
            return funcionarios.get(i);
        }
        
    }
    return null;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(){
      if(!nome.toUpperCase().equals("")){
          this.nome = nome;
      }
        }
    }
    

