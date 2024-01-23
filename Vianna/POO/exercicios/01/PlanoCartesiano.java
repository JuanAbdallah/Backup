
public class PlanoCartesiano
{
    private double x1,x2,y1,y2;
    
    public PlanoCartesiano(){
        
    }
    public PlanoCartesiano(double x1, double x2, double y1, double y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        
    }
    
    public double calculaDistancia(double x1, double x2, double y1, double y2){
        double distancia = ((x2 - x1)*(x2 - x1) + ((y2 - y1)*(y2 - y1)));
        return distancia;
    }
    
}
