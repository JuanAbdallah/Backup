import java.util.Scanner;
public class Principal
{
    public void main(String args[]){
        Turma turma = new Turma();
        Scanner le = new Scanner(System.in);
        Aluno a = new Aluno();
        Aluno b = new Aluno();
        Aluno c = new Aluno();
        Aluno d = new Aluno();
        Aluno e = new Aluno();
        
        System.out.println("Cadastrar Aluno 1:");
        System.out.println("Digite o seu nome:");
        a.setNome(le.next());
        System.out.println("Escolha de 1 a 5 o aluno que deseja votar");
        a.setVoto(le.nextInt());
        turma.addAluno( a );
        
        System.out.println("Cadastrar Aluno 2:");
        System.out.println("Digite o seu nome:");
        b.setNome(le.next());
        System.out.println("Escolha de 1 a 5 o aluno que deseja votar");
        b.setVoto(le.nextInt());
        turma.addAluno( b );
        
        System.out.println("Cadastrar Aluno 3:");
        System.out.println("Digite o seu nome:");
        c.setNome(le.next());
        System.out.println("Escolha de 1 a 5 o aluno que deseja votar");
        c.setVoto(le.nextInt());
        turma.addAluno( c );
        
        System.out.println("Cadastrar Aluno 4:");
        System.out.println("Digite o seu nome:");
        d.setNome(le.next());
        System.out.println("Escolha de 1 a 5 o aluno que deseja votar");
        d.setVoto(le.nextInt());
        turma.addAluno( d );
        
        System.out.println("Cadastrar Aluno 5:");
        System.out.println("Digite o seu nome:");
        e.setNome(le.next());
        System.out.println("Escolha de 1 a 5 o aluno que deseja votar");
        e.setVoto(le.nextInt());
        turma.addAluno( e );
        
    }
}
