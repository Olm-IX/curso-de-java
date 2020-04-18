//INTERFACE FUNCIONAL é uma interface que possui um único método abstrato. 
//Suas implementações serão tratadas como expressões lambda.
//Na linguagem Java, no fundo as expressões lambdas são tratadas como interfaces funcionais. 
//Em linguagens funcionais puras isso não é assim, existem só as funções e expressões lambdas. 
//Mas como o Java é uma linguagem que já veio da orientação a objetos, manteve essa 
//equivalência entre expressões lambdas e interfaces!

//CONSUMER represents an operation that accepts a single input argument and returns no result. 
//Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
//https://docs.oracle.com/javase/10/docs/api/java/util/function/Consumer.html

//The Consumer Interface is a part of the java.util.function package 
//which has been introduced since Java 8, to implement functional programming in Java. 
//It represents a function which takes in one argument and produces a result. 
//However these kind of functions don’t return any value.
//The lambda expression assigned to an object of Consumer type is used to define its accept() 
//which eventually applies the given operation on its argument. 
//Consumers are useful when it not needed to return any value as they are expected to operate via side-effects.

//Possui o método abstrato accept()

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import entities.Produto;

public class TesteConsumer {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		// Produto(nome, preço)
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Tv", 900.00));
		produtos.add(new Produto("Mouse", 50.00));
		produtos.add(new Produto("Tablet", 350.50));
		produtos.add(new Produto("HD Case", 80.90));
		
//		---- Método 1 - Implementação da interface

//		Obs.: apenas para fim didático, a classe foi criada aqui mesmo
		class PriceConsumer implements Consumer<Produto> {
			@Override
			public void accept(Produto produto) {
				produto.setPreco(produto.getPreco() * 1.1);;
			}
		}
		
//		.forEach é um método default da interface List, que recebe um Consumer como argumento
		produtos.forEach(new PriceConsumer());
//		Reference method para imprimir!
		produtos.forEach(System.out::println);
//			output:
//				Tv - 990.00
//				Mouse - 55.00
//				Tablet - 385.55
//				HD Case - 88.99

		
//		---- Método 2 - Reference method com método estático
		
//		Foi criado o método estático aumentaPrecoConsumer na classe Produto
		produtos.forEach(Produto::aumentaPrecoConsumerEstatico);
		produtos.forEach(System.out::println);
//			output:
//				Tv - 1089.00
//				Mouse - 60.50
//				Tablet - 424.11
//				HD Case - 97.89

		
//		---- Método 3 - Reference method com método não estático
		
		produtos.forEach(Produto::aumentaPrecoConsumerNaoEstatico);
		produtos.forEach(System.out::println);
//			output:
//				Tv - 1197.90
//				Mouse - 66.55
//				Tablet - 466.52
//				HD Case - 107.68
		
		
//		---- Método 4 - Expressão lambda declarada
		
//		Obs.: usei chaves apenas como exemplo, quando a função possui só uma linha as chaves são opcionais
//		Consumer<Produto> cons = p -> p.setPreco(p.getPreco()*1.1);
		Consumer<Produto> cons = p -> {
			p.setPreco(p.getPreco()*1.1);
		};
		
		produtos.forEach(cons);
		produtos.forEach(System.out::println);
//			output:
//				Tv - 1317.69
//				Mouse - 73.21
//				Tablet - 513.17
//				HD Case - 118.45

		
//		---- Método 5 - Expressão lambda inline
		
		produtos.forEach(p -> p.setPreco(p.getPreco()*1.1));
		produtos.forEach(System.out::println);
//		output:
//			Tv - 1449.46
//			Mouse - 80.53
//			Tablet - 564.48
//			HD Case - 130.29
		
//		---- andThen()
		
//		Returns a composed Consumer that performs, in sequence, this operation followed by the after operation
		
		produtos.forEach(cons.andThen(System.out::println));
//			output:
//				Tv - 1594.40
//				Mouse - 88.58
//				Tablet - 620.93
//				HD Case - 143.32
		
		
		
	}

}
