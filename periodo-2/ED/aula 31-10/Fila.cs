public class Fila
{
    public void Adicionar(int valor)
    {
        var novoNo = new No { Valor = valor };

        if (primeiro == null)
            primeiro = ultimo = novoNo;
        else
        {
            ultimo.Proximo = novoNo;
            ultimo = novoNo;
        }
    }

    public void Remover()
    {
        if(primeiro = null){
            throw new Exception ("Não há mais elementos na fila");
        }
        if(primerio = ultimo){
            primeiro = ultimo = null
        }else{
        primeiro = primeiro.Proximo;
        }
    }

    private No primeiro = null;
    private No ultimo = null;
}