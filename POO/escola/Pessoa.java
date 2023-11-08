

public abstract class Pessoa
{
   private String nome, telefone, email;
   
   
   public Pessoa(){}
   
   public abstract String toString();
   
   public void setNome(String nome){
       this.nome = nome;
   }
    public String getNome(){
       return nome;
   }
   
   public void setTelefone(String Telefone){
       this.telefone = telefone;
   }
    public String getTelefone(){
       return telefone;
   }
   
   public void setEmail(String email){
       this.email = email;
   }
    public String getEmail(){
       return email;
   }
}
