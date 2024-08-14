

public class Enfermeiro extends Funcionario implements ISindicato, IPericulosidade 
{
  private double salarioBase;
  private int numeroPlantoes;
  
  public double salario(){
      return salarioBase + (numeroPlantoes * 500);
  }
  public double decimoTerceiro(){
      return salario();
  }
  
  public double contribuicaoSindical(){
      return 0;
  }
  public double adicionaPericulosidade(){
      return 0;
  }
}
