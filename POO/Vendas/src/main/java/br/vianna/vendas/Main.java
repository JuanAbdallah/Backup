package br.vianna.vendas;

import br.vianna.vendas.model.Produto;
import br.vianna.vendas.model.e.EEstado;
import br.vianna.vendas.model.impl.ICMS;
import br.vianna.vendas.model.impl.IVA;
import br.vianna.vendas.model.impl.cupom.CupomFixo;
import br.vianna.vendas.model.vendas.ItemVenda;
import br.vianna.vendas.model.vendas.Venda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner le = new Scanner(System.in);

        System.out.println("Bem vindo");
        Produto prod = new Produto();
        System.out.println("Nome: ");
        prod.setNome( le.nextLine() );
        System.out.println("Preço Custo: ");
        prod.setPreco( le.nextDouble() );
        prod.addImposto( new IVA() );
        System.out.println("Estado: ");
        String est = le.next().toUpperCase();

        System.out.println("Preço Final sem impostos R$ "+prod.precoVenda());

        prod.addImposto( new ICMS(EEstado.valueOf(est)) );

        System.out.println("Preço Final com impostos R$ "+prod.precoVenda());

        Venda v = new Venda();

        ItemVenda iv = new ItemVenda(prod, 2, prod.precoVenda());

        v.addProduto(iv);
        System.out.println("valor venda sem desconto R$ "+v.totalVenda());

        v.setCupom( new CupomFixo(10));

        System.out.println("valor venda com desconto R$ "+v.totalVenda());

    }
}