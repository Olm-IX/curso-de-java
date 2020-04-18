//Represents a function that accepts one argument and produces a result.
//This is a functional interface whose functional method is apply(Object).

//Function recebe um objeto como entrada e devolve um objeto como saída
//Function<Entrada, Saida>

//https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

import entities.Produto;

public class TesteFunction {

	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		
		// Produto(nome, preço)
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Tv", 900.00));
		produtos.add(new Produto("Mouse", 50.00));
		produtos.add(new Produto("Tablet", 350.50));
		produtos.add(new Produto("HD Case", 80.90));
		
//		Percorrer a lista de produtos e criar uma nova lista com os nomes em caixa alta
		
		
//		---- Método 1 - Implementação da interface

//		Obs.: apenas para fim didático, a classe foi criada aqui mesmo
		class NomeMaiusculoFunction implements Function<Produto, String> {
			@Override
			public String apply(Produto produto) {
				return produto.getNome().toUpperCase();
			}
		}
		
//		A função "map" (não confundir com a estrutura de dados Map) é uma função que aplica uma função a todos
//		os elementos de uma Stream
//		1)Converte List para stream: .stream()
//		2)Aplica a função a todos os elementos da stream: .map(FUNÇÃO)
//		3)Converte stream para List: .collect(Collectors.toList())
		
		List<String> nomes = produtos.stream().map(new NomeMaiusculoFunction()).collect(Collectors.toList());
		nomes.forEach(System.out::println);
//			output:
//				TV
//				MOUSE
//				TABLET
//				HD CASE


//		---- Método 2 - Reference method com método estático

//		Foi criado o método estático nomeMaiusculoEstatico na classe Produto
		List<String> nomes2 = produtos.stream().map(Produto::nomeMaiusculoEstatico).collect(Collectors.toList());
		nomes2.forEach(System.out::println);
//			output:
//				TV
//				MOUSE
//				TABLET
//				HD CASE
		
		
		
//		---- Método 3 - Reference method com método não estático
		
		List<String> nomes3 = produtos.stream().map(Produto::nomeMaiusculoNaoEstatico).collect(Collectors.toList());
		nomes3.forEach(System.out::println);
//			output:
//				TV
//				MOUSE
//				TABLET
//				HD CASE
		
		
//		---- Método 4 - Expressão lambda declarada
		
		Function<Produto,String> nomeMaiusculo = p -> p.getNome().toUpperCase();
//		Function<Produto, String> nomeMaiusculo = p -> {
//			return p.getNome().toUpperCase();
//		};		
		List<String> nomes4 = produtos.stream().map(nomeMaiusculo).collect(Collectors.toList());
		nomes4.forEach(System.out::println);
//			output:
//				TV
//				MOUSE
//				TABLET
//				HD CASE


//		---- Método 5 - Expressão lambda inline
		
		List<String> nomes5 = produtos.stream().map(p -> p.getNome().toUpperCase()).collect(Collectors.toList());
		nomes5.forEach(System.out::println);
//			output:
//				TV
//				MOUSE
//				TABLET
//				HD CASE
		
	}
	
}
