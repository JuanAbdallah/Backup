import java.util.ArrayList;
public class Turma
{
   
    private ArrayList<Aluno> alunos;
    public Turma(){
        alunos = new ArrayList<>();
    }
   
    
    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }
    public void addAluno(Aluno a){
        alunos.add( a );
    }
    
   
    public int nroVoto(int nroVotos){
        return nroVotos;
    }
    
    public int votos(){
        for(Aluno a: alunos){
          if(a.getVoto() == 1){
              
          }
        }
        return 0;
    }
    
}
