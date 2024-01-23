
import java.util.ArrayList;
public class Numeros
{
   private int valor;
   private ArrayList<Numeros> numero;
   public Numeros(){
       numero = new ArrayList<>();
   }
   public Numeros(int valor){
       this.valor = valor;
       numero = new ArrayList<>();
   }
   
   public int getValor(){
       return valor;
   }
   public void setValor(int valor){
       this.valor = valor;
   }
   
  
}
