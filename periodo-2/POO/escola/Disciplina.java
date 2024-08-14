
public class Disciplina implements IDisciplina
{
    private String nome;
    private Professor professor;
    private double nota1, nota2;
    
    public Disciplina(String nome, Professor p){
        this.nome = nome;
        this.professor = p;
        
    }
    
    public boolean isAprovado(){
      return mediaFinal() >= 7;
    }
    
    public double mediaFinal(){
        return 0;
    }
    public void setNome(String nome){
       this.nome = nome;
   }
    public String getNome(){
       return nome;
   } 
   
   public Professor getProfessor(){
       return professor;
   }
   public void setProfessor(Professor p){
       this.professor = p ;
   }
   
    public void setNota1(double nota1){
       this.nota1 = nota1;
   }
    public double getNota1(){
       return nota1;
   } 
   
    public void setNota2(double nota2){
       this.nota2 = nota2;
   }
    public double getNota2(){
       return nota2;
   } 
}
