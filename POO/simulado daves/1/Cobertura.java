

public class Cobertura extends Imovel
{
   boolean duplex, triplex; 
   
    public double valorVenal(){
        if(duplex == true){
            return 1000* getMetrosQuadrados() + 1000;
        }
        if(triplex == false){
            return 1000 * getMetrosQuadrados() + 1500;
        }
       return 0;
   }
}
