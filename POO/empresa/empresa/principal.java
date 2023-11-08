import java.util.Scanner;
public class principal
{
   public static void main(String args[]){
       Scanner leia = new Scanner(System.in);
       
       System.out.println("### EMPRESA XPTO ###");
       
       System.out.println("# informe o nome da empresa?");

       Empresa emp  = new Empresa(leia.next());
       //Ler os Funcionarios
       System.out.println("empresa: " + emp.getNome());

       while(true){
           Funcionario f = new Funcionario();
           System.out.println("## Nome do Funcionario");
           f.setNome(leia.next());
           System.out.println("## Salario Bruto?");
           f.setSalarioBruto(leia.nextDouble());
           System.out.println("## Numero de Filhos?");
           f.setNumeroFilhos(leia.nextInt());
           System.out.println("## usa Vale transporte?");
           f.setUsaValeTransporte(leia.nextBoolean());
           System.out.println("## E Gerente?(Sim ou Nao)");
           f.setEhGerente(leia.next().equalsIgnoreCase("S"));
           
           emp.addFuncionarios(f);
           
           System.out.println("##nome"+f.getNome() + "salario R$"+f.salarioLiquido());
           
           System.out.println("Deseja cadastrar outro?(S/N)");
           if(leia.next().equalsIgnoreCase("N")){
               break;
           }
           
       }
       
       System.out.println("# empresa::"+emp.getNome());
       System.out.println("# Total :: R$ " + emp.totalPagamento());
       
   }
}
