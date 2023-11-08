import java.util.ArrayList;

public class Funcionario
{
    private double horasTrabalhadas, salarioHora;
    private int numeroDependentes;
   
    public Funcionario(){
    }
    public Funcionario(double horasTrabalhadas, double salarioHora,
    int numeroDependentes){
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioHora = salarioHora;
        this.numeroDependentes = numeroDependentes;
    }
    
    public double getHorasTrabalhadas(){
        return horasTrabalhadas;
    }
    public void setHorasTrabalhadas(double horasTrabalhadas){
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    public double getSalarioHora(){
        return salarioHora;
    }
    public void setSalarioHora(double salarioHora){
        this.salarioHora = salarioHora;
    }
    
     public int getNumeroDependentes(){
        return numeroDependentes;
    }
    public void setNumeroDependentes(int numeroDependentes){
        this.numeroDependentes = numeroDependentes;
    }
}
