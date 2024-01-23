static class MetodoBolha
{
    public static void Executar(Produto[] vetor)
    {
        //Ordenar por preço
               int fim = vetor.Length - 1, ultimaTroca;
        
        do
        {
            ultimaTroca = 0;

            for (int j = 0; j < fim; j++)
            {
                if (vetor[j].Preco > vetor[j+1].Preco)
                {
                    Trocar2(vetor, j, j + 1);
                    ultimaTroca = j + 1;
                }
            }

            fim = ultimaTroca;
        } while (ultimaTroca > 0);
    }

    public static void Executar(int[] vetor)
    {
        int fim = vetor.Length - 1, ultimaTroca;
        
        do
        {
            ultimaTroca = 0;

            for (int j = 0; j < fim; j++)
            {
                if (vetor[j] > vetor[j+1])
                {
                    Trocar(vetor, j, j + 1);
                    ultimaTroca = j + 1;
                }
            }

            fim = ultimaTroca;
        } while (ultimaTroca > 0);
    }

    static void Trocar(int[] vetor, int indice1, int indice2)
    {
        var aux = vetor[indice1];
        vetor[indice1] = vetor[indice2];
        vetor[indice2] = aux;
    }
     static void Trocar2(Produto[] vetor, int indice1, int indice2)
    {
        var aux = vetor[indice1];
        vetor[indice1] = vetor[indice2];
        vetor[indice2] = aux;
    }
}