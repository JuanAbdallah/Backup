
import java.util.ArrayList;

public class Empresa
{
     private double horasTrabalhadas, salarioHora;
    private int numeroDependentes;
   
    public Empresa(){
    }
    public Empresa(double horasTrabalhadas, double salarioHora,
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
     
    public double calculoSalario(){
        
        double Salario = getHorasTrabalhadas() * getSalarioHora() + 
        (50 * getNumeroDependentes());
        
        return Salario;
    }
    
    public double descontoINSS(){
        double inss = 0;
        if(calculoSalario() <= 1000){
            inss = calculoSalario() * 8.5/100;
        }
        if(calculoSalario() > 1000){
            inss = calculoSalario() * 9/100;
        }
        return inss;
    }
    
    public double descontoIR(){
        double ir = 0;
        if(calculoSalario() <= 500){
            ir = 0;
        }
        if(calculoSalario() < 500 && calculoSalario() <= 100){
            ir = calculoSalario() * 7/100;
        }
        if(calculoSalario() > 100){
            ir = calculoSalario() * 7/100;
        }
        return ir;
    }
    
    public double salarioLiquido(){
        return calculoSalario() - descontoINSS() - descontoIR();
    }
}
