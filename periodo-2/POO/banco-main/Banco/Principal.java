

public class Principal
{
    public static void main(String args[]){
        
        System.out.println("");
        
        Conta c = new Poupanca();
        
        c.depositar(1000);
        c.sacar(1100);
        ((Poupanca)c).rendimento(0.05);        
        
        Poupanca p = new Poupanca();
        p.depositar(1000);
        
        c = new ContaEspecial();
        ((ContaEspecial)c).setlimiteCredito(500);
        c.depositar(1000);
        c.sacar(1100);
        
        if (c instanceof Poupanca){
            ((Poupanca)c).rendimento(0.05);
        }
        
    }
}
