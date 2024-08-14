import java.util.ArrayList;
public class Governo
{
     ArrayList<Pescador> pescadores;
     public Governo(){
          pescadores = new ArrayList<>();
     }
     
     public ArrayList<Pescador> getPescadores(){
         return pescadores;
     }
     public void addPescadores(Pescador pesc){
         pescadores.add(pesc);
     }
     
     public double Imposto(){
             double quant = 0;
             for(Pescador p : pescadores){
                  if(p.getPesoPeixe() > 50){
                      quant = (p.getPesoPeixe() - 50) * 4;
                  }
         }
         return quant;
     }
        
     }
     

