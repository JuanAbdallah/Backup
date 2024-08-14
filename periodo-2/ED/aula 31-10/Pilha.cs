public class Pilha
{
    public void Empilhar(int valor)
    {
        var novoNo = new No {Valor = valor};

        novoNo.Proximo = topo;
        topo = novoNo;
    }

    public void Desempilhar()
    {
        if (topo == null)
            throw new Exception("Não há elementos a serem desempilhados.");
        
        topo = topo.Proximo;
    }

    public int? Topo
    {
        get { return topo?.Valor; }
    }

    private No topo = null;
}
