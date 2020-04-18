//Represents a predicate (boolean-valued function) of one argument.
//Retorna um valor booleano
//https://docs.oracle.com/javase/10/docs/api/java/util/function/Predicate.html
//Na linguagem Java, as express�es lambda s�o tratadas como interfaces funcionais.
//Interface Java.util.function.Predicate -> This is a functional interface and can therefore 
//be used as the assignment target for a lambda expression or method reference.
//Possui o m�todo abstrato test()

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
		pessoas.add(new Pessoa("Tio Patinhas", 86, "Escoc�s"));
		pessoas.add(new Pessoa("Artorias the Abysswalker", 40, "Lordraniano"));
		pessoas.add(new Pessoa("Saruman the White", 10000, "Isengardiano"));

		
//		---- M�todo 1 - Implementa��o da interface

//		Obs.: apenas para fim did�tico, a classe foi criada aqui mesmo
		class IsOldPredicate implements Predicate<Pessoa> {
			@Override
			public boolean test(Pessoa pessoa) {
				return pessoa.getIdade() >= 60;
			}
		}

//		O m�todo removeIf() recebe um Predicate como argumento
//		pessoas.removeIf(new IsOldPredicate());
//		System.out.println(pessoas); // output: [Naila, Link, Artorias the Abysswalker]
		
		IsOldPredicate isOld = new IsOldPredicate();		
		pessoas.forEach(p -> System.out.println(p + " � idoso(a)? " + isOld.test(p)));	
//			output:
//				Naila � idoso(a)? false
//				Link � idoso(a)? false
//				Tio Patinhas � idoso(a)? true
//				Artorias the Abysswalker � idoso(a)? false
//				Saruman the White � idoso(a)? true
		
		
//		---- M�todo 2 - Reference method com m�todo est�tico
		
//		Reference method -> (Classe::m�todo) ->  It is compact and easy form of lambda expression
//		Each time when you are using lambda expression to just referring a method, 
//		you can replace your lambda expression with method reference.
		
//		Foi criado um m�todo est�tico isOldStaticPredicate na classe Pessoa 
//		pessoas.removeIf(Pessoa::isOldStaticPredicate);
//		System.out.println(pessoas); // output: [Naila, Link, Artorias the Abysswalker]


//		---- M�todo 3 - Reference method com m�todo n�o est�tico
		
//		Tamb�m funciona normalmente com o m�todo n�o est�tico
//		Predicate.not() foi introduzido no Java 11
//		pessoas.removeIf(Predicate.not(Pessoa::isOldNonStaticPredicate));
//		System.out.println(pessoas); // output: [Tio Patinhas, Saruman the White]

		
//		---- M�todo 4 - Express�o lambda declarada
	
//		Essa express�o lambda � uma fun��o an�nima que recebe como argumento a Pessoa p
//		e retorna um booleano
//		Predicate<Pessoa> predEMenorDeIdade = p -> p.getIdade() < 18;
//		pessoas.removeIf(predEMenorDeIdade.negate());
//		System.out.println(pessoas); // output: [Link]
		
		
//		---- M�todo 5 - Express�o lambda inline
		
//		pessoas.removeIf(p -> !(p.getIdade() < 18));
//		System.out.println(pessoas); // [Link]
		
		
//		---- Outras observa��es
		
//		Predicado simples
		Predicate<Pessoa> maioridadePredicate = p -> p.getIdade() >= 18;
		boolean b1 = maioridadePredicate.test(pessoas.get((1))); // Link
		System.out.println(b1 ? "Adulto" : "Crian�a"); // output: Crian�a
//		isEqual
		Predicate<String> isengardValidaPredicate = Predicate.isEqual("Isengardiano");
		boolean b5 = isengardValidaPredicate.test(pessoas.get(4).getNacionalidade()); // Saruman
		System.out.println(b5 ? "� isengardiano" : "N�o � isengardiano"); // output: � isengardiano
		
//		Predicado composto
		Predicate<Pessoa> naoIdosoPredicate = p -> p.getIdade() < 70;
//		and
		boolean b2 = maioridadePredicate.and(naoIdosoPredicate).test(pessoas.get(0)); // Naila
		System.out.println(b2 ? "Adulto" : "Idoso"); // output: Adulto
//		Quando o primeiro predicado � executado e este � falso, ent�o o outro predicado n�o � avaliado.
//		Um predicado composto, tamb�m pode ser feito com operadores l�gicos de maneira expl�cita:
		Predicate<Pessoa> idadeValidaPredicate = p -> p.getIdade() > 18 && p.getIdade() < 70;
		boolean b3 = idadeValidaPredicate.test(pessoas.get(0)); // Naila
		System.out.println(b3 ? "Adulto" : "Idoso"); // output: Adulto
//		or
		boolean b4 = naoIdosoPredicate.or(maioridadePredicate.negate()).test(pessoas.get(4)); // Saruman
		System.out.println(b4 ? "Adulto" : "N�o adulto (crian�a ou idoso)"); // output: N�o adulto (crian�a ou idoso)

	}

}
