//Represents a predicate (boolean-valued function) of one argument.
//Retorna um valor booleano
//https://docs.oracle.com/javase/10/docs/api/java/util/function/Predicate.html
//Na linguagem Java, as expressões lambda são tratadas como interfaces funcionais.
//Interface Java.util.function.Predicate -> This is a functional interface and can therefore 
//be used as the assignment target for a lambda expression or method reference.
//Possui o método abstrato test()

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entities.Pessoa;

public class TestePredicate {

	public static void main(String[] args) {

		List<Pessoa> pessoas = new ArrayList<>();
//		Pessoa(nome, idade, nacionalidade)
		pessoas.add(new Pessoa("Naila", 28, "Brasileira"));
		pessoas.add(new Pessoa("Link", 12, "Hyruleano"));
		pessoas.add(new Pessoa("Tio Patinhas", 86, "Escocês"));
		pessoas.add(new Pessoa("Artorias the Abysswalker", 40, "Lordraniano"));
		pessoas.add(new Pessoa("Saruman the White", 10000, "Isengardiano"));

		
//		---- Método 1 - Implementação da interface

//		Obs.: apenas para fim didático, a classe foi criada aqui mesmo
		class IsOldPredicate implements Predicate<Pessoa> {
			@Override
			public boolean test(Pessoa pessoa) {
				return pessoa.getIdade() >= 60;
			}
		}

//		O método removeIf() recebe um Predicate como argumento
//		pessoas.removeIf(new IsOldPredicate());
//		System.out.println(pessoas); // output: [Naila, Link, Artorias the Abysswalker]
		
		IsOldPredicate isOld = new IsOldPredicate();		
		pessoas.forEach(p -> System.out.println(p + " é idoso(a)? " + isOld.test(p)));	
//			output:
//				Naila é idoso(a)? false
//				Link é idoso(a)? false
//				Tio Patinhas é idoso(a)? true
//				Artorias the Abysswalker é idoso(a)? false
//				Saruman the White é idoso(a)? true
		
		
//		---- Método 2 - Reference method com método estático
		
//		Reference method -> (Classe::método) ->  It is compact and easy form of lambda expression
//		Each time when you are using lambda expression to just referring a method, 
//		you can replace your lambda expression with method reference.
		
//		Foi criado um método estático isOldStaticPredicate na classe Pessoa 
//		pessoas.removeIf(Pessoa::isOldStaticPredicate);
//		System.out.println(pessoas); // output: [Naila, Link, Artorias the Abysswalker]


//		---- Método 3 - Reference method com método não estático
		
//		Também funciona normalmente com o método não estático
//		Predicate.not() foi introduzido no Java 11
//		pessoas.removeIf(Predicate.not(Pessoa::isOldNonStaticPredicate));
//		System.out.println(pessoas); // output: [Tio Patinhas, Saruman the White]

		
//		---- Método 4 - Expressão lambda declarada
	
//		Essa expressão lambda é uma função anônima que recebe como argumento a Pessoa p
//		e retorna um booleano
//		Predicate<Pessoa> predEMenorDeIdade = p -> p.getIdade() < 18;
//		pessoas.removeIf(predEMenorDeIdade.negate());
//		System.out.println(pessoas); // output: [Link]
		
		
//		---- Método 5 - Expressão lambda inline
		
//		pessoas.removeIf(p -> !(p.getIdade() < 18));
//		System.out.println(pessoas); // [Link]
		
		
//		---- Outras observações
		
//		Predicado simples
		Predicate<Pessoa> maioridadePredicate = p -> p.getIdade() >= 18;
		boolean b1 = maioridadePredicate.test(pessoas.get((1))); // Link
		System.out.println(b1 ? "Adulto" : "Criança"); // output: Criança
//		isEqual
		Predicate<String> isengardValidaPredicate = Predicate.isEqual("Isengardiano");
		boolean b5 = isengardValidaPredicate.test(pessoas.get(4).getNacionalidade()); // Saruman
		System.out.println(b5 ? "É isengardiano" : "Não é isengardiano"); // output: É isengardiano
		
//		Predicado composto
		Predicate<Pessoa> naoIdosoPredicate = p -> p.getIdade() < 70;
//		and
		boolean b2 = maioridadePredicate.and(naoIdosoPredicate).test(pessoas.get(0)); // Naila
		System.out.println(b2 ? "Adulto" : "Idoso"); // output: Adulto
//		Quando o primeiro predicado é executado e este é falso, então o outro predicado não é avaliado.
//		Um predicado composto, também pode ser feito com operadores lógicos de maneira explícita:
		Predicate<Pessoa> idadeValidaPredicate = p -> p.getIdade() > 18 && p.getIdade() < 70;
		boolean b3 = idadeValidaPredicate.test(pessoas.get(0)); // Naila
		System.out.println(b3 ? "Adulto" : "Idoso"); // output: Adulto
//		or
		boolean b4 = naoIdosoPredicate.or(maioridadePredicate.negate()).test(pessoas.get(4)); // Saruman
		System.out.println(b4 ? "Adulto" : "Não adulto (criança ou idoso)"); // output: Não adulto (criança ou idoso)

	}

}
