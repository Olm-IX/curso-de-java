package model.services;

import java.util.List;
import java.util.function.Predicate;

import entities.Produto;

public class ProdutoService {

	public double somaFiltradaT(List<Produto> produtos) {
		double soma = 0;
		for (Produto produto : produtos) {
			if (produto.getNome().charAt(0) == 'T') {
				soma += produto.getPreco();
			}
			
		}
		return soma;
	}
	
	public double somaFiltrada(List<Produto> produtos, Predicate<Produto> condicao) {
		double soma = 0;
		for (Produto produto : produtos) {
			if (condicao.test(produto)) {
				soma += produto.getPreco();
			}
		}
		return soma;
	}

}
