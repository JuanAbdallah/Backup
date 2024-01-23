
public class Motorista extends Funcionario
{
    public final double VALOR_HORA_PADRAO = 35.59;
    private int numeroViagens;
    private int numeroPernoite;
    private double tempoViagem;
    private int auxilioAlimentacao;
    
    public double salario(){
        return (numeroViagens + VALOR_HORA_PADRAO/2) + 
        (numeroPernoite * 300) + (tempoViagem * (VALOR_HORA_PADRAO))+
         auxilioAlimentacao;
    }
    
    public double decimoTerceiro(){
        return salario() * 1.3;
    }
}
