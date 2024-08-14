

public class Apartamento extends Imovel
{
    private int nroQuarto;
   
   public double valorVenal(){
       return 1000* getMetrosQuadrados() + (nroQuarto * 500);
   }
}
