import java.util.ArrayList;

public abstract class Imovel
{
    private int numero;
    protected int metrosQuadrados;
    private String proprietario;
    private Condominio condominio;
    public Imovel(){
        
    }
    
    public int getNumero(){
        return numero;
    }
    public void setNumero(){
        this.numero = numero;
    }
    
    public int getMetrosQuadrados(){
        return metrosQuadrados;
    }
    public void setMetrosQuadrados(){
        this.metrosQuadrados = metrosQuadrados;
    }
    
     public String getProprietario(){
        return proprietario;
    }
    public void setProprietario(String proprietario){
        this.proprietario = proprietario;
    }
    
         public Condominio getCondominio(){
        return condominio;
    }
    public void setCondominio(Condominio condominio){
        this.condominio = condominio;
    }
    
    public abstract double valorVenal();
    
    public double valorVenda(){
        if(getClass() == Casa.class){
            return valorVenal() + metrosQuadrados * 350;
        }
        return valorVenal() * 0.85;
    }
    
}
