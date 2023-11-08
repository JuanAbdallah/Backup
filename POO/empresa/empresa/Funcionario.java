
public class Funcionario
{
    private String nome;
    private double salarioBruto;
    private int numeroFilhos;
    private boolean usaValeTransporte, ehGerente;
    //construtor
    
    public Funcionario(String vNome, double vSalBruto, boolean vVale
    , boolean vGerente, int vNumFilhos){
        nome = vNome;
        salarioBruto = vSalBruto;
        usaValeTransporte = vVale;
        ehGerente = vGerente;
        numeroFilhos = vNumFilhos;
        
    }
     public Funcionario(){}
    
    public void setNome(String nome){
        if(!nome.equals("")){ 
        this.nome = nome;}
        
    }
    // metodos da classe
    public double salarioLiquido(){
       return salarioBruto - inss() - descontoVale() + bonusPorFilho() +
       bonusGerencia();
    }
    public double inss(){
        return 0.13* salarioBruto;
    }
    public double descontoVale(){
        return (usaValeTransporte)?(salarioBruto*0.03):0;
    }
    public double bonusPorFilho(){
        return (numeroFilhos >= 0 && numeroFilhos <= 3)?(numeroFilhos * 115
        ):3 * 115;
    }
    public double bonusGerencia(){
        return (ehGerente)? (salarioBruto * 0.1):0;
    }
    //metodos de acesso
    public String getNome(){
        return nome;
    }
    public int getNumeroFilhos(int numeroFilhos){
        return this.numeroFilhos;
    }
    public void setNumeroFilhos(int numeroFilho){
        if(numeroFilhos >= 0){
            this.numeroFilhos = numeroFilhos;
        }
    }
    public double getSalarioBruto(){
        return this.salarioBruto;
    }
    public void setSalarioBruto(double salarioBruto){
        if(salarioBruto >= 0){
            this.salarioBruto = salarioBruto;
        }
    }
    public boolean getEhGerente(){
        return this.ehGerente;
    }
    public void setEhGerente(boolean ehGerente){
       
            this.ehGerente = ehGerente;
        }
        public boolean getUsaValeTransporte(){
        return this.usaValeTransporte;
    }
    public void setUsaValeTransporte(boolean usaValeTransporte){
       
            this.usaValeTransporte = usaValeTransporte;
        }
    }

    

