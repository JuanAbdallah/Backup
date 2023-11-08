
public class DisciplinaConceito implements IDisciplina
{
  private String nome;
    private Professor professor;
    private ENotaConceito nota;
    
    public DisciplinaConceito(String nome, Professor p){
        this.nome = nome;
        this.professor = p;
        
    }
    
    public boolean isAprovado(){
      return (nota == ENotaConceito.A)||(nota == ENotaConceito.B)||(nota == ENotaConceito.C)
      ||(nota == ENotaConceito.D);
    }
    
    public double mediaFinal(){
        if(nota == ENotaConceito.A){
            return 10;
        }
        if(nota == ENotaConceito.B){
            return 8;
        }
        if(nota == ENotaConceito.C){
            return 7;
        }
        if(nota == ENotaConceito.D){
            return 4;
        }
        else{
            return 0;
        }
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
   
    public void setNota(ENotaConceito nota){
       this.nota = nota;
   }
    public ENotaConceito getNota(){
       return nota;
   } 
   
   
}
