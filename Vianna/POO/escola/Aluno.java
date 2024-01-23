import java.util.ArrayList;

public class Aluno extends Pessoa
{
    private ArrayList<Matricula> anosLetivos;
    
    public ArrayList<Matricula> getAnosLetivos(){
        return anosLetivos;
    }
    public void matricularAno(Matricula d){
        anosLetivos.add(d);
    }
    @Override
    public String toString(){
        String msg = "###### ALUNO ######\n"+
                     "#Nome.....:" + getNome() + "\n" +
                     "#Email.....:" + getEmail() + "\n" +
                     "#Nome.....:" + getTelefone() + "\n" +
                     "#Aprovado.....:";
                     return msg;
    }
}
