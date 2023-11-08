int inicio = 1, fim = 5;

Console.WriteLine($"Soma dos pares entre {inicio} e {fim}: {SomaPares(inicio, fim)}.");

Console.WriteLine($"Soma dos números entre {inicio} e {fim}: {SomaIntervalo(inicio, fim)}.");

int SomaPares(int primeiro, int ultimo)
{
    if (primeiro > ultimo)
        return 0;
    
    return (primeiro % 2 == 0 ? primeiro : 0) + SomaPares(primeiro + 1, ultimo);
}

int SomaIntervalo(int primeiro, int ultimo)
{
    if (primeiro > ultimo)
        return 0;
    
    return primeiro + SomaIntervalo(primeiro + 1, ultimo);
}
