import java.util.ArrayList;
public class Pesquisa
{
    private ArrayList<Entrevistado> entrevistados;
    private String dataPesquisa;
    
    public Pesquisa(String data){
        this.dataPesquisa = data;
        entrevistados = new ArrayList<>();
    }
    
    //a) maior e menor altura
    public Entrevistado getEntrevistadoMenorAltura(){
        if(entrevistados.size() > 0){
        Entrevistado maior = entrevistados.get(0);
        for(Entrevistado e : entrevistados){
            if(e.getAltura() > maior.getAltura()){
                maior = e;
            }
        }
        return maior;
    }
        return null;
    }
    public Entrevistado getEntrevistadoMaiorAltura(){
        if(entrevistados.size() > 0){
        Entrevistado menor = entrevistados.get(0);
        for(Entrevistado e : entrevistados){
            if(e.getAltura() < menor.getAltura()){
                menor = e;
            }
        }
        return menor;
    }
        return null;
    }
    
    //b) homem mais velho
    public Entrevistado getHomemMaisVelho(){
        if(entrevistados.size() > 0){
            Entrevistado velho = new Entrevistado();
            velho.setIdade(0);
            for(Entrevistado e : entrevistados){
                if(e.getIdade() > velho.getIdade() &&
                (e.getSexo() == 'M' || e.getSexo() == 'm')){
                    velho = e;
                }
            }
            return velho;
        }
        return null;
    }
    
    //b) mulher mais velha
    public Entrevistado getMulherMaisVelha(){
        if(entrevistados.size() > 0){
            Entrevistado velho = new Entrevistado();
            velho.setIdade(0);
            for(Entrevistado e : entrevistados){
                if(e.getIdade() > velho.getIdade() &&
                (e.getSexo() == 'f' || e.getSexo() == 'F')){
                    velho = e;
                }
            }
            return velho;
        }
        return null;
    }
    
    //c) media de altura das mulheres
    public double getMediaAlturaMulheres(){
        if(entrevistados.size() > 0){
            double soma = 0;
            for(Entrevistado e : entrevistados){
                if(e.getSexo() == 'f' || e.getSexo() == 'F'){
                    soma += e.getAltura();
                }
            }
            return soma/getQuantidadeMulheres();
        }
        return 0;
    }
    
    //d) numero de homens
    public int getQuantidadeHomens(){
        if(entrevistados.size() > 0){
            int total = 0;
            for(Entrevistado e : entrevistados){
                if(e.getSexo() == 'M' || e.getSexo() == 'm'){
                    total++;
                }
            }
            return total;
        }
        return 0;
    }
    public int getQuantidadeMulheres(){
        return entrevistados.size() - getQuantidadeHomens();
    }
    
    public double getPercentualHomens(){
        return getQuantidadeHomens()*100/entrevistados.size();
    }
    public double getPercentualMulheres(){
        return getQuantidadeMulheres()*100/entrevistados.size();
    }
    
    public double getPercentualPesquisa(){
        if(entrevistados.size() > 0){
            int totalPerfil = 0;
            for(Entrevistado e : entrevistados){
                 if(e.temPerfil()){
                 return totalPerfil*100/entrevistados.size();
                }
            }
            
        }
        return 0;
    }
    
    public void setDataPesquisa(String dataPesquisa){
          this.dataPesquisa = dataPesquisa; 
  }
    public String getDataPesquisa(){
      return dataPesquisa;
  }
    
    public ArrayList<Entrevistado> getEntrevistados(){
        return entrevistados;
      }
  
      public void adicionaEntrevistado(Entrevistado ent){
      if(ent  != null){
          entrevistados.add(ent);
      }
    }
}
