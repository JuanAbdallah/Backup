import java.util.Scanner;

public class Main
{
   public static void main (String [] args){
       Triangulo lado1 = new Triangulo();
       Triangulo lado2 = new Triangulo();
       Triangulo lado3 = new Triangulo();
       Scanner le = new Scanner(System.in); 
       System.out.println("Digite o primeiro lado do tringulo");
       lado1.setLado(le.nextDouble());
       System.out.println("Digite o segundo lado do tringulo");
       lado2.setLado(le.nextDouble());
       System.out.println("Digite o terceiro lado do tringulo");
       lado3.setLado(le.nextDouble());
       
       if(lado1.getLado() == lado2.getLado() && lado2.getLado() == lado3.getLado()
        && lado1.getLado() == lado3.getLado()){
           System.out.println("Equilatero");
       }else if(lado1.getLado() == lado2.getLado() || lado2.getLado() == lado3.getLado()
        || lado1.getLado() == lado3.getLado()){
           System.out.println("Isoceles");
        }else{
           System.out.println("Escaleno");
        }
        
       double soma = (lado1.getLado() +lado2.getLado()  + lado3.getLado())
       / 2;  
       
       double area = Math.sqrt(soma * (soma - lado1.getLado())
       * (soma - lado2.getLado()) * (soma - lado3.getLado()));
       
        System.out.println("A area do triangulo e: " + area); 
       
   }

}
