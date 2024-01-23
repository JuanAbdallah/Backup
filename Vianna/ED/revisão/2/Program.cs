internal class Program
{
    private static void Main(string[] args)
    {
        int[] vet = new int[5]{-1,-2,-3,-4,5};
        int positivo = Multiplica(vet);
    }

    static int Multiplica(int[] vet, int i = 0){
        
        if(vet[i] < 0){
            vet[i] *= - 1;
            Console.WriteLine(vet[i]);
            return Multiplica(vet, i + 1);
        }else{
            Console.WriteLine(vet[i]);
            return Multiplica(vet, i + 1);
            
        }
    }
}