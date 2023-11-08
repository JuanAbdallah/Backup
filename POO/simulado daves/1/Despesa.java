import java.util.ArrayList;

public class Despesa
{
    int mesAno;
    String descricao;
    double valor;
    boolean taxaExtra;
    
    public Despesa(){}
    public Despesa(int mesAno,String descricao,double valor, boolean taxaExtra)
    {
       this.mesAno = mesAno;
       this.descricao = descricao;
       this.valor = valor;
       this.taxaExtra = taxaExtra; 
    }
    
    public int getMesAno(){
        return mesAno;
    }
    public void setmMesAno(int mesAno){
        this.mesAno = mesAno;
    }
    
    public String getescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public double getValor(){
        return valor;
    }
    public void setValor(double valor){
        this.valor = valor;
    }
    
    public boolean getTaxaExtra(){
        return taxaExtra;
    }
    public void setTaxaExtra(boolean taxaExtra){
        this.taxaExtra = taxaExtra;
    }
}
