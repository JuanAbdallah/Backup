using System.Collections.Specialized;
using System.Configuration.Assemblies;
using System.Data;
using System.Globalization;
using System.Runtime.InteropServices;

internal class Program
{
    private static void Main(string[] args)
    {
        double[] vetor = new double[5] { 50, 30, 70, 20, 5 };
        Bolha(vetor);
        for (int i = 0; i < vetor.Length; i++)
        {
            Console.WriteLine(vetor[i]);
        }

    }

    static void TrocaVetor(double[] vet, int i, int j)
    {
        double aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;

    }
    static void Bolha(double[] vetor)
    {
        int pos; int fim = vetor.Length - 1;
        do{
            pos = - 1;
            for(int i = 0; i < fim; i++){
                if(vetor[i] < vetor[i + 1] ){
                    TrocaVetor(vetor, i , i + 1);
                    pos = i;
                }
                fim = pos;
            }

        }while(fim > 0);
    }
    static void Insercao(double[] vetor)
    {
       for(int i = 1; i < vetor.Length; i++){
        double chave = vetor[i];
        int j = i - 1;
        while(j >= 0 && chave < vetor[j]){
            vetor[j + 1] = vetor[j];
            j --;
        }
        vetor[j + 1] = chave;
       }
    }

    static void Selecao(double[] vetor)
    {
        for(int i = 0; i < vetor.Length - 1; i++){
            int indMenor = i;
            for(int j = i + 1; j < vetor.Length; j ++){
                if(vetor[j] < vetor[indMenor]){
                    indMenor = j;
                }
                if(indMenor != i){
                    TrocaVetor(vetor, i , indMenor);
                }
            }
        }
    }



}
