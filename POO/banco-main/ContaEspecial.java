

// Coesao - alta (Quantidade de coisas que um metodo faz)
// Acoplamento - baixo (quantidade dependencias uma classe tem)

public class ContaEspecial extends Conta
{
    private double limiteCredito;
    
    @Override
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
