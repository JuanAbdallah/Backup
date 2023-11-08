import java.util.ArrayList;

public class Triangulo
{
    private double lado;
    private ArrayList<Triangulo> lados;
    
    public Triangulo(){ 
        lados = new ArrayList<>();
}
public Triangulo(double lado){
    this.lado = lado;
    lados = new ArrayList<>();
   
}
public double getLado(){
    return lado;
}
public void setLado(double lado){
    this.lado = lado;
}
}
