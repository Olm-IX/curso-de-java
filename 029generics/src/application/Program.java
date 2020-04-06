//Vamos fazer um m�todo que copia os elementos de uma lista para uma
//outra lista que pode ser mais gen�rica que a primeira.

package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {

		List<String> myStr = Arrays.asList("teste", "maria", "joao");

		List<Double> myDbl = Arrays.asList(3.5, 4.6, 1.1);

		List<Object> myObj = new ArrayList<>();

//		copy(myStr, myDbl); // Erro de compila��o pois Double n�o � super de String
		copy(myStr, myObj); // Ok! Object � super de String
		copy(myDbl, myObj); // Ok! Object � super de Double

		print(myObj); // output: teste maria joao 3.5 4.6 1.1

		List<Integer> intList = new ArrayList<Integer>();
		intList.add(10);
		intList.add(5);
		
//		COVARI�NCIA -> pode acessar mas n�o pode adicionar novos elementos
		List<? extends Number> list = intList;
		Number x = list.get(0); // ok!
//		list.add(20); // erro de compilacao.
//			O compilador n�o vai saber se esse inteiro "20" � compat�vel com outro poss�vel
//			tipo de Number (ex. Double, Byte, etc) de que poderia ser sua lista

		List<Object> objList = new ArrayList<Object>();
		objList.add("Naila");
		objList.add("Luiz");
		
//		CONTRAVARI�NCIA -> pode adicionar novos elementos mas n�o pode acessar
		List<? super Number> lista = objList;
		lista.add(10.5); // ok!
//		Number y = lista.get(0); // erro de compila��o
//		String y = lista.get(0); // erro de compila��o
		
	}

	/**
	 * Recebe uma lista source de um tipo gen�rico T, e adiciona cada elemento em
	 * uma lista destiny do tipo super T (mais gen�rica).
	 */
	public static <T> void copy(List<? extends T> source, List<? super T> destiny) {
		for (T item : source) {
			destiny.add(item);
		}
	}

	public static void print(List<?> list) {
		for (Object item : list) {
			System.out.print(item + " ");
		}
	}

}
