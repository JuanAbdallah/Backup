//string? significa que pode-se receber string e null.
Console.WriteLine("Informe seu nome: ");
string? nome = Console.ReadLine() ?? "";// se for null retorna o valor da direita e se não for null 
                                        //recebe o valor da esquerda.


Console.WriteLine("Informe a sua idade: ");
int idade = Convert.ToInt32(Console.ReadLine());

Console.WriteLine($"Nome: {nome}, idade: {idade + 1}.");

Console.WriteLine($"O seu nome possui {nome.Length} letras.");
