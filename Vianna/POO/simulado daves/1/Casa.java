

public class Casa extends Imovel implements ICondominioFechado
{
   private int metragemTerreno; 
   public Casa(){
       
   }
    public double valorVenal(){
       return getMetrosQuadrados() * 1500;
   }
   public double valorTerreno(){
       return metragemTerreno * 350;
   }
}
