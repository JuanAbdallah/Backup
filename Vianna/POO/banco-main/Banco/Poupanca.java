
public class Poupanca extends Conta
{
    public void rendimento(double taxaJuros){
        if(taxaJuros>= 0 && taxaJuros<=1){
            //saldo*=(1+taxajuros);
            depositar(saldo * (taxaJuros));
        }
    }
}
