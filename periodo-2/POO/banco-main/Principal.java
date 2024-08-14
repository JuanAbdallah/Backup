import java.util.Scanner;
import java.util.ArrayList;

public class Principal
{
    private static Scanner leExt = new Scanner(System.in);
    
    public static void main(String args[]){
        Scanner le = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();  
        Banco bco = new Banco("Banco do Brasil");
        System.out.println("##### GERBAN "+bco.getNome().toUpperCase()+"#####");
        
        /*while(true){
            System.out.println("## 1) Cadastrar Cliente");
            System.out.println("## 2) Criar Conta");
            System.out.println("## 3) Operaçoes");
            System.out.println("## 4) Relatorios");
            System.out.println("## 5) Sair");
            int escolha = le.nextInt();le.nextLine();
            
            if(escolha ==5){
                break;
            }else if (escolha == 1){
                Cliente c = new Cliente();
                System.out.print("## Nome do cliente: ");
                c.setNome(le.nextLine());
                System.out.print("## CPF do cliente: ");
                c.setCpf(le.nextLine());
                
                clientes.add(c);
            }
            System.out.println("");
        }*/
        while(true)
        {
            int escolha = montaMenu(le);
            if(escolha == 5){
                break;
            }else if(escolha == 1){
                clientes.add( novoCliente() );
            }else if(escolha == 2){
                bco.addConta( criarConta(bco, clientes) );
            }else if(escolha == 3){
                realizarOperacoes(bco);
            }else if(escolha == 4){
                imprimeDados( bco, clientes );
            }else{
                System.out.println("Opçao Invalida!!!");
            }
        }
        System.out.println("Ate Logo" + clientes.size());
        
    }
    
    public static void realizarOperacoes(Banco b){
        //listar e escolher contas 
        Conta c = escolhaConta(b.getContas());
        //escolher uma conta
        System.out.println("### Escolha a operaçao" + "(D)eposito ou (R)etirada");
        String op = leExt.next();
        
        //escolhe operaçao
        //digitar o valor
        //realizar a operaçao
        if(leExt.next().equalsIgnoreCase("D")){
            System.out.println("Escolha o valor da operaçao::");
            c.depositar(leExt.nextDouble());
        }else{
            System.out.println("Escolha o valor da operaçao::");
            c.sacar(leExt.nextDouble());
        }
        System.out.println("O seu novo saldo e de R$" + c.getSaldo());
    }
    
    
    public static Conta escolhaConta(ArrayList<Conta> contas){
        System.out.println("Escolha uma das contas:");
        int i = 1;
        for(Conta c : contas){
            System.out.println("#" + (i++)+")" + c.getNumero() + "("
            +c.getClass()+")");
        }
        int escolha = leExt.nextInt();
        
        return contas.get(escolha - 1);
    }
    public static void imprimeDados(Banco bco, ArrayList<Cliente> clientes){
        System.out.println("## Relatorios ");
        System.out.println("## numero de Clientes:" + clientes.size());
        System.out.println("## numero de contas:" +bco.getContas().size());
        System.out.println("## Saldo Contas Banco:" + bco.saldoContas());
        System.out.println("## Nome do primeiro Cliente do Banco:"
        + bco.getContas().get(0).getCliente().getNome());
        System.out.println("## Clientes:");
        for(Cliente c : clientes){
            System.out.println("####" + c.getNome() + "R$" + c.saldoContas() + 
            "numero de contas"+c.getMinhasContas().size());
            for(Conta cc : c.getMinhasContas()){
                System.out.println("#### Conta " + cc.getNumero() + "(" + cc.getClass()+")");
            }
        }
        System.out.println("## Nome do Cliente com maior Saldo:" + bco.getClienteMaiorSaldo().
        getNome());
    }
    
    public static Cliente escolhaCliente(ArrayList<Cliente>clientes){
        int i = 1;
        for(Cliente c: clientes){
            System.out.print("##" + (i++)+") " + c.getNome());
        }
        int escolha = leExt.nextInt();
        
        return clientes.get(escolha - 1);
    }
    // 1ª soluçao: passar scanner como parametro
    public static int montaMenu(Scanner le){   //metodos com static nao precisam de um objeto para funcionar
        System.out.println("## 1) Cadastrar Cliente");
        System.out.println("## 2) Criar Conta");
        System.out.println("## 3) Operaçoes");
        System.out.println("## 4) Relatorios");
        System.out.println("## 5) Sair");
        int i = le.nextInt();le.nextLine();
        return i;
    }
    
    // 2ª soluçao: instanciar um novo objeto scanner
    public static Cliente novoCliente(){   
        Scanner le = new Scanner(System.in);
        
        Cliente c = new Cliente();
        System.out.print("## Nome do cliente: ");
        c.setNome(le.nextLine());
        System.out.print("## CPF do cliente: ");
        c.setCpf(le.nextLine());
                
        return c;
    }
    
    // 3ª soluçao: criar uma variavel scanner static
    public static Conta criarConta(Banco bco, ArrayList<Cliente> clientes){
        System.out.println("## escolha o tipo de conta: (C)onta, (P)oupança ou Conta (E)special");
        String resp = leExt.next();
        Conta c;
        //c = (resp.equalsIgnoreCase("C"))? new Conta(): (resp.equalsIgnoreCase("P"))? new Poupanca() : new ContaEspecial();
        
        if (resp.equalsIgnoreCase("C"))
            c = new Conta();
        else if(resp.equalsIgnoreCase("P"))
            c = new Poupanca();
        else
            c = new ContaEspecial();
            
        System.out.println("### informe o numero da conta");
        c.setNumero(leExt.next());
        System.out.println("### informe a agencia da conta");
        c.setAgencia(leExt.next());
        c.setBanco(bco);
        
        if(c instanceof ContaEspecial){
            System.out.println("### Informe o limite da conta:");
            ((ContaEspecial)c).setlimiteCredito( leExt.nextDouble());
            //terminar codigo
        }
        
        System.out.println("#### Clientes ja cadastrados, escolha 1:");
        
        c.setCliente( escolhaCliente(clientes));
        Cliente cli = escolhaCliente(clientes);
        c.setCliente( cli );
        cli.addConta( c );
        
        
        //c.setCliente();
        return c;
    }
}
