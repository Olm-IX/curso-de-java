package application;

import java.util.ArrayList;
import java.util.List;

import entities.Produto;
import model.services.ProdutoService;

public class TesteCriandoFuncao {

	public static void main(String[] args) {

//		Como criar uma função que recebe uma função lambda como argumento

//		Fazer um programa que, a partir de uma lista de produtos, calcule a soma
//		dos preços somente dos produtos cujo nome começa com 'T'

		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Tv", 900.00));
		produtos.add(new Produto("Mouse", 50.00));
		produtos.add(new Produto("Tablet", 350.50));
		produtos.add(new Produto("HD Case", 80.90));

		ProdutoService ps = new ProdutoService();

		double soma = ps.somaFiltradaT(produtos);
		System.out.println(String.format("Soma: %.2f", soma));
//			output:
//				Soma: 1250,50

//		O método acima efetua a soma filtrada pelos produtos que começam com a letra T.
//		Porém, se quisermos modificar a condição do método, para produtos que comecem com
//		outra letra, por exemplo, ou outra condição qualquer, teremos que ir lá na classe ProdutoService
//		e modificar o método. Isso não é algo muito bom! Para isso, iremos criar um método que receba um
//		Predicado como argumento, e então poderemos passar a condição na chamada do método.

		soma = ps.somaFiltrada(produtos, p -> p.getNome().charAt(0) == 'T');
		System.out.println(String.format("Soma: %.2f", soma));
//			output:
//				Soma: 1250,50

//		Passei a condição como uma expressão lambda! Agora podemos definir outras condições.
		
		soma = ps.somaFiltrada(produtos, p -> p.getNome().charAt(0) == 'M');
		System.out.println(String.format("Soma: %.2f", soma));
//			output:
//				Soma: 50,00

		soma = ps.somaFiltrada(produtos, p -> p.getPreco() < 100.0);
		System.out.println(String.format("Soma: %.2f", soma));
//			output:
//				Soma: 130,90

	}

}
