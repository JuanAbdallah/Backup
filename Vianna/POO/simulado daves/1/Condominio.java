import java.util.ArrayList;


public class Condominio
{
    private String nome;
    private String endereco;
    ArrayList <Despesa> despesas;
    ArrayList<Imovel> imoveis;
    ArrayList<Pagamento> pagamentos;
    public Condominio(){
        despesas = new ArrayList<>();
        imoveis = new ArrayList<>();
    }
    
    public Condominio(String nome, String endereco){
        despesas = new ArrayList<>();
        imoveis = new ArrayList<>();
        this.nome = nome;
        this.endereco = endereco;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public ArrayList<Despesa> getDespesa(){
        return despesas;
    }
    public void addDespesas(Despesa d){
        this.despesas.add( d );
    }
    
    public ArrayList<Imovel> getImovel(){
        return imoveis;
    }
    public void addImovel(Imovel i){
        imoveis.add(i);
    }
    
    public ArrayList<Pagamento> getPagamentos(){
        return pagamentos;
    }
    public void addPagamentos(Pagamento p){
        pagamentos.add(p);
    }
    
    public void pagarCondominio(Imovel imovel, int mesAno){
        Pagamento p = new Pagamento(mesAno,valorCondominio(mesAno), this,imovel );
        
        pagamentos.add(p);
    }
    
    private int totalPago(int mesAno){
        int totPago = 0;
        for(Pagamento p : pagamentos){
            if(p.getMesAno() == mesAno){
           totPago += p.getValorPago(); 
        }
        }
        return totPago;
    }
    
    public double valorCondominio(int mesAno){
        double total = 0;
        for(Despesa d : despesas){
            if(d.getMesAno() == mesAno){
                total += d.getValor();
            }
        }
        return total/imoveis.size();
    }
    
    public String relatorio(){
        int mes = 1;
        String resultado = "";
        
        resultado += "Mes: " + mes + "- 2023";
        int totPg = totalPago(Integer.parseInt( mes + "2023"));
        resultado += imoveis.size()+ "apartamentos("+totPg+ "pagos - " +
        (imoveis.size() - totPg) + "nao pagos)";
        resultado+= "valor arrecadado: R$"+ 
        (totPg * valorCondominio(Integer.parseInt( mes + "2023")));
        return resultado;
    }
    
}
