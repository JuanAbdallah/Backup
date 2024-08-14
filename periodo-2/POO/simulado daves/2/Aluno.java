

public class Aluno
{
    private String nome;
    private int voto;
    public Aluno(){
        
    }
    public Aluno(String nome, int voto){
        this.nome = nome;
        this.voto = voto;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getVoto(){
        return voto;
    }
    public void setVoto(int voto){
        this.voto = voto;
    }
}
