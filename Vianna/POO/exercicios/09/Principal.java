import java.util.Scanner;
public class Principal
{
   public static void main(String[]args){
       Scanner leia = new Scanner(System.in);
       Pescador p = new Pescador();
       Governo e = new Governo();
       System.out.println("Digite o peso do seu peixe em kg");
       p.setPesoPeixe(leia.nextDouble());
       if(p.getPesoPeixe() > 50){
           System.out.println("O seu imposto será de R$" + e.Imposto() );
        }else{
            System.out.println("Não existe impostos para serem pagos");        }
   }
}
