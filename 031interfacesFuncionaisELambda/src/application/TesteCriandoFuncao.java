package application;

import java.util.ArrayList;
import java.util.List;

import entities.Produto;
import model.services.ProdutoService;

public class TesteCriandoFuncao {

	public static void main(String[] args) {

//		Como criar uma fun��o que recebe uma fun��o lambda como argumento

//		Fazer um programa que, a partir de uma lista de produtos, calcule a soma
//		dos pre�os somente dos produtos cujo nome come�a com 'T'

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

//		O m�todo acima efetua a soma filtrada pelos produtos que come�am com a letra T.
//		Por�m, se quisermos modificar a condi��o do m�todo, para produtos que comecem com
//		outra letra, por exemplo, ou outra condi��o qualquer, teremos que ir l� na classe ProdutoService
//		e modificar o m�todo. Isso n�o � algo muito bom! Para isso, iremos criar um m�todo que receba um
//		Predicado como argumento, e ent�o poderemos passar a condi��o na chamada do m�todo.

		soma = ps.somaFiltrada(produtos, p -> p.getNome().charAt(0) == 'T');
		System.out.println(String.format("Soma: %.2f", soma));
//			output:
//				Soma: 1250,50

//		Passei a condi��o como uma express�o lambda! Agora podemos definir outras condi��es.
		
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
