// Coesao - alta (Quantidade de coisas que um metodo faz)
// Acoplamento - baixo (Quantidade de dependencias que uma classe tem) 

public class ContaEspecial extends Conta
{
    private double limiteCredito;
    
    
    public void sacar(double valor){
        if (valor >= 0 && valor <= (getSaldo()+limiteCredito)){
            saldo -= valor;
        }
    }
    
    public double getlimiteCredito(){
        return limiteCredito;
    }
    public void setlimiteCredito(double limiteCredito){
        this.limiteCredito = limiteCredito;
    }
}
