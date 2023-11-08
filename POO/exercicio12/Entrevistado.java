

public class Entrevistado
{
  private int idade;
  private double altura;
  private char sexo;
  private String corOlhos;
  private ETipoCorCabelo corCabelos;
  
  public Entrevistado(){}
  public Entrevistado(int idade, double altura, char sexo, String corOlhos,
  ETipoCorCabelo corCabelos){
      this.idade = idade;
      this.altura = altura;
      setSexo(sexo);
      setCorOlhos(corOlhos);
      this.corCabelos = corCabelos;
  }
  
  public void setIdade(int idade){
      if (idade >= 0){
          this.idade = idade;
      }
  }
  public int getIdade(){
      return idade;
  }
  
  public void setAltura(int altura){
      if (idade >= 0){
          this.altura = altura;
      }
  }
  public int getAltura(){
      return sexo;
  }
  
  public void setSexo(char sexo){
      if (sexo == 'M' || sexo == 'F' || sexo == 'm' || sexo == 'f'){
          this.sexo = sexo;
      }
  }
  public char getSexo(){
      return sexo;
  }
  
  public void setCorOlhos(String corOlhos){
      if (corOlhos.toUpperCase().equals("VERDE")||
          corOlhos.toUpperCase().equals("CASTANHO") ||
          corOlhos.toUpperCase().equals("AZUL")){
          this.corOlhos = corOlhos;
      }
  }
  public String getCorOlhos(){
      return corOlhos;
  }
  
  public void setCorCabelo(ETipoCorCabelo corCabelos){     
          this.corCabelos = corCabelos;
  }
  public ETipoCorCabelo getCorCabelos(){
      return corCabelos;
  }
  
  public boolean temPerfil(){
      return (getSexo() == 'f' || getSexo() == 'F' && 
                 (getIdade() >= 18 && getIdade() <= 35) && (
                 getCorOlhos().equals("VERDE")) &&
                 getCorCabelos() == ETipoCorCabelo.LOIRO);
                    
                 
  }
}
