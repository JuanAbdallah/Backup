import java.util.ArrayList;
public class Carro
{
   double precoModelo; 
   boolean importante, motor1,ar, alarme,
   pinturaEspecial, tetoSolar, kitM;
   
   public Carro(){
       
   }
   public Carro(boolean importante,boolean motor1,boolean ar,boolean alarme,
   boolean pinturaEspecial,boolean tetoSolar,boolean kitM, double precoModelo){
        this.importante = importante;
        this.motor1 = motor1;
        this.ar = ar;
        this.alarme = alarme;
        this.pinturaEspecial = pinturaEspecial;
        this.tetoSolar = tetoSolar;
        this.kitM = kitM;
        this.precoModelo = precoModelo;

   }
   public double precoCarro(){
       return precoModelo +ipi() + ehImportante() - ehMotor1() + temAr() 
       + temAlarme() + temPinturaEspecial() + temSolar() + temKitM() ;
       
   }
   public double ehImportante(){
       if(importante)
       return precoModelo *= 0.30;
       
       return 0;
   }
    public double temAr(){
       if(ar)
       return 3000;
       
       return 0;
   }
   public double temAlarme(){
       if(alarme)
       return 5000;
       
       return 0;
   }
   public double temPinturaEspecial(){
       if(pinturaEspecial)
       return 800;
       
       return 0;
   }
   public double temSolar(){
       if(tetoSolar)
       return 2500;
       
       return 0;
   }
   public double temKitM(){
       if(kitM)
       return 1800;
       
       return 0;
   }
   public double ehMotor1(){
       if(motor1)
       return precoModelo *= 0.10;
       
       return 0;
   }
   public double ipi(){
       return precoModelo *= 0.20;
   }
   public boolean getImportante(){
       return importante;    
   }
   public void setImportante(boolean importante){
        this.importante = importante;      
   }
   
   public boolean getMotor(){
       return motor1;    
   }
   public void setMotor1(boolean Motor1){
       motor1 = this.motor1;    
   }
   
   public boolean getAr(){
       return ar;    
   }
   public void setAr(boolean ar){
       ar = this.ar;    
   }
   
   public boolean getAlarme(){
       return ar;    
   }
   public void setAlarme(boolean alarme){
       alarme = this.alarme;    
   }
   
   public boolean getPinturaEspecial(){
       return pinturaEspecial;    
   }
   public void setPinturaEspecial(boolean pinturaEspecial){
       pinturaEspecial = this.pinturaEspecial;    
   }
   
   public boolean getTetoSolar(){
       return tetoSolar;    
   }
   public void setTetoSolar(boolean tetoSolar){
       tetoSolar = this.tetoSolar;    
   }
   
   public boolean getKitM(){
       return tetoSolar;    
   }
   public void setKitM(boolean kitM){
       kitM = this.kitM;    
   }
   
   public double PrecoModelo(){
       return precoModelo;    
   }
   public void setPrecoModelo(double precoModelo){
       this.precoModelo = precoModelo;    
   }
}
