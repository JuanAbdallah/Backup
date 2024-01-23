import java.util.ArrayList;

public class Pessoas
{
   String nome, nasc, email;
   int idade;
   private ArrayList<Pessoas> pessoa;
   
   public Pessoas(){
       pessoa = new ArrayList<>();
   }
   public Pessoas(String nome, String nasc, String email,int idade){
       this.nome = nome;
       this.email = email;
       this.nasc = nasc;
       this.idade = idade;
       
       pessoa = new ArrayList<>();
       
   }
   public String getNome(){
       return nome;
   }
   public void setNome(String nome){
       this.nome = nome;
   }
   
   public String getEmail(){
       return email;
   }
   public void setEmail(String email){
       this.email = email;
   }
   
   public String getNasc(){
       return nasc;
   }
   public void setNasc(String nasc){
       this.nasc = nasc;
   }
   
   public int getIdade(){
       return idade;
   }
   public void setIdade(int idade){
       this.idade = idade;
   }
   
   public boolean maiorIdade(){
       if(idade >= 18){
       return true;
    }else{
       return false;
    }
   }
   
}
