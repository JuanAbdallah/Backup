using System.IO.Compression;

internal class Program
{
    private static void Main(string[] args)
    {
        int n = 50;
        Imprime(n);
    }

    static void Imprime(int n, int i = 1){
        
        if(i < n){
            if(i % 2 == 0 && i % 3 == 0){
                Console.WriteLine(i);
            }
            Imprime(n , i + 1);
        }
    }
}