import java.util.Scanner;
public class Principal
{
    public static void main(String args[]){
        Scanner le = new Scanner(System.in);
        Empresa e = new Empresa ();
        System.out.println("horas trabalhadas:");
        e.setHorasTrabalhadas(le.nextDouble());
        System.out.println("salario por hora");
        e.setSalarioHora(le.nextDouble());
        System.out.println("numero de dependentes:");
        e.setNumeroDependentes(le.nextInt());
        
         System.out.println("Salario Bruto: " + e.calculoSalario());
        System.out.println("Desconto INSS: " + e.descontoINSS());
        System.out.println("Desconto IR: " + e.descontoIR());
        System.out.println("Salario Liquido: " + e.salarioLiquido());
        
        
    }
    
   
}
