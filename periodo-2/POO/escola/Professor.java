

public class Professor extends Pessoa
{
    private double salario;
    @Override
    public String toString(){
        String msg = "###### PROFESSOR ######\n"+
                     "#Nome.....:" + getNome() + "\n" +
                     "#Email.....:" + getEmail() + "\n" +
                     "#Nome.....:" + getTelefone() + "\n" +
                     "#Salario.....:" +salario + "\n";
                     return msg;
    }
    
    public void setSalario(double salario){
       this.salario = salario;
   }
    public double getSalario(){
       return salario;
   }
}
