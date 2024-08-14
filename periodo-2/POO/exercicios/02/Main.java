import java.util.Scanner;
public class Main
{
    public static void main(String[] args){
        Numeros a = new Numeros();
        Numeros b = new Numeros();
        Scanner sc = new Scanner(System.in);
        System.out.println("digite o valor de A e depois o valor de B:");
        a.setValor(sc.nextInt());
        b.setValor(sc.nextInt());
        if(a.getValor() < b.getValor()){
        for(int i = a.getValor() + 1; i < b.getValor() ; i++){
            if( i % 2 != 0)
            System.out.println(i);
        }
    }
        else if(a == b){
            System.out.println("Os números são iguais");
        }
        else{
            for(int i = b.getValor() + 1; i < a.getValor() ; i++){
                if( i % 2 != 0)
                System.out.println(i);
            }
        }
    }
}
