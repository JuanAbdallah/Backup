package br.vianna.vendas.model.impl.cupom;

import br.vianna.vendas.model.faces.ICupom;

public class CupomPercentual implements ICupom {

    private double percentualDesconto;

    public CupomPercentual(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public double desconto(double precoTotal) {
        return precoTotal * (precoTotal/100);
    }
}
