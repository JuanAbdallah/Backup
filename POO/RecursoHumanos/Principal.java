import java.util.Scanner;
import java.util.ArrayList;
public class Principal
{
   public static void main(String args[]){
       System.out.println("Cadastro");
       Scanner le = new Scanner(System.in);
       
       ISindicato sind = new Enfermeiro();
       IPericulosidade peri = new Enfermeiro();
       Funcionario func = new Enfermeiro();
       
       ArrayList<IPericulosidade> lista = new ArrayList<>();
       lista.add(new Bombeiro());
       lista.add(new Enfermeiro());
       
       peri.adicionaPericulosidade()
   }
}
