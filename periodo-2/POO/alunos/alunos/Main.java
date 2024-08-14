
public class Main
{
    //Leitura e escrita
    public static void main(String args[]){
        System.out.println("### notas  ######");
        
        Aluno a1, a2;
        
        a1 = new Aluno ("Pedrin", 8.5);
        
        a2 = new Aluno ("Zezin", 4.5);
        
        if(a1.isAprovado()){
            System.out.println(a1.nome + " Esta aprovado");
        }
        else{
            System.out.println(a1.nome + " Esta reprovado");
        }
        
        if(a2.isAprovado()){
            System.out.println(a2.nome + " Esta aproivado");
        }else{
            System.out.println(a2.nome + " Esta reprovado");
        }
        //imprimir o aluno de maior nota
        
            
            
            
            
            
            
            
            
            
        }
    }
}
