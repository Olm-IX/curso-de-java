//INTERFACE FUNCIONAL � uma interface que possui um �nico m�todo abstrato. 
//Suas implementa��es ser�o tratadas como express�es lambda.
//Na linguagem Java, no fundo as express�es lambdas s�o tratadas como interfaces funcionais. 
//Em linguagens funcionais puras isso n�o � assim, existem s� as fun��es e express�es lambdas. 
//Mas como o Java � uma linguagem que j� veio da orienta��o a objetos, manteve essa 
//equival�ncia entre express�es lambdas e interfaces!

//CONSUMER represents an operation that accepts a single input argument and returns no result. 
//Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
//https://docs.oracle.com/javase/10/docs/api/java/util/function/Consumer.html

//The Consumer Interface is a part of the java.util.function package 
//which has been introduced since Java 8, to implement functional programming in Java. 
//It represents a function which takes in one argument and produces a result. 
//However these kind of functions don�t return any value.
//The lambda expression assigned to an object of Consumer type is used to define its accept() 
//which eventually applies the given operation on its argument. 
//Consumers are useful when it not needed to return any value as they are expected to operate via side-effects.

//Possui o m�todo abstrato accept()

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import entities.Produto;

public class TesteConsumer {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		// Produto(nome, pre�o)
		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Tv", 900.00));
		produtos.add(new Produto("Mouse", 50.00));
		produtos.add(new Produto("Tablet", 350.50));
		produtos.add(new Produto("HD Case", 80.90));
		
//		---- M�todo 1 - Implementa��o da interface

//		Obs.: apenas para fim did�tico, a classe foi criada aqui mesmo
		class PriceConsumer implements Consumer<Produto> {
			@Override
			public void accept(Produto produto) {
				produto.setPreco(produto.getPreco() * 1.1);;
			}
		}
		
//		.forEach � um m�todo default da interface List, que recebe um Consumer como argumento
		produtos.forEach(new PriceConsumer());
//		Reference method para imprimir!
		produtos.forEach(System.out::println);
//			output:
//				Tv - 990.00
//				Mouse - 55.00
//				Tablet - 385.55
//				HD Case - 88.99

		
//		---- M�todo 2 - Reference method com m�todo est�tico
		
//		Foi criado o m�todo est�tico aumentaPrecoConsumer na classe Produto
		produtos.forEach(Produto::aumentaPrecoConsumerEstatico);
		produtos.forEach(System.out::println);
//			output:
//				Tv - 1089.00
//				Mouse - 60.50
//				Tablet - 424.11
//				HD Case - 97.89

		
//		---- M�todo 3 - Reference method com m�todo n�o est�tico
		
		produtos.forEach(Produto::aumentaPrecoConsumerNaoEstatico);
		produtos.forEach(System.out::println);
//			output:
//				Tv - 1197.90
//				Mouse - 66.55
//				Tablet - 466.52
//				HD Case - 107.68
		
		
//		---- M�todo 4 - Express�o lambda declarada
		
//		Obs.: usei chaves apenas como exemplo, quando a fun��o possui s� uma linha as chaves s�o opcionais
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

		
//		---- M�todo 5 - Express�o lambda inline
		
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
