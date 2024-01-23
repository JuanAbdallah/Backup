import java.util.Scanner;

public class Principal
{
    public static void main(String atgs[]){
        Scanner le = new Scanner(System.in);
        
        System.out.println("## Data da Pesquisa");
        Pesquisa pesq = new Pesquisa(le.nextLine());
        
        while(true){
            Entrevistado e = new Entrevistado();
            System.out.println("## idade : ");
            e.setIdade(le.nextInt());
            System.out.println("## altura : ");
            e.setAltura(le.nextInt());
            System.out.println("## sexo(M/F) : ");
            e.setSexo(le.next().toUpperCase().charAt(0));
            System.out.println("## cor dos olhos : (1 - verde | 2 - castanho | 3 - azul) ");
            //e.setCorOlhos(le.next().toUpperCase());
            int esc = le.nextInt();
            if(esc == 1){e.setCorOlhos("VERDE");}else
            if(esc == 2){e.setCorOlhos("CASTANHO");}else
            {e.setCorOlhos("AZUL");}
            System.out.println("## cor dos cabelos : (1 - loiro | 2 - castanho | 3 - preto) ");
            
            esc = le.nextInt();
            if(esc == 1){e.setCorCabelo(ETipoCorCabelo.LOIRO);}else
            if(esc == 2){e.setCorCabelo(ETipoCorCabelo.CASTANHO);}else
            {e.setCorCabelo(ETipoCorCabelo.PRETO);}
            
            pesq.adicionaEntrevistado(e);
            System.out.print("## Deseja sair? (S/N)");
            if(le.next().equalsIgnoreCase("S")){
                break;
            }
            System.out.println("######## resultados: ########)");
            System.out.println(" a) mais alto:" + pesq.getEntrevistadoMaiorAltura().getAltura());
            System.out.println(" a) mais baixo:" + pesq.getEntrevistadoMenorAltura().getAltura());
            System.out.println(" b) homem mais velho:" + pesq.getHomemMaisVelho().getIdade());
            System.out.println(" b) mulher mais velha:" + pesq.getMulherMaisVelha().getIdade());
            System.out.println(" c) Media Idade das Mulheres:" + pesq.getMediaAlturaMulheres());
            System.out.println(" d) numero de homens: " + pesq.getQuantidadeHomens());
            System.out.println(" e) % de homens: " + pesq.getPercentualHomens());
            System.out.println(" e) % de mulheres: " + pesq.getPercentualMulheres());
            System.out.println(" e) % de mulheres entre 18 e 35 anos, de olhos verdes e loiras: " + pesq.getPercentualPesquisa());
            
            
        }
    }
}
