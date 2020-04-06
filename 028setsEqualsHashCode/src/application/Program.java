package application;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import entities.Aluno;
import entities.Curso;

public class Program {

	public static void main(String[] args) {

		Curso cursoDeInformatica = new Curso("Inform�tica");

		Aluno a1 = new Aluno("Luiz Quintas", 1080);
		Aluno a2 = new Aluno("Naila Silva", 1440);

		cursoDeInformatica.matricula(a1);
		cursoDeInformatica.matricula(a2);

		System.out.println(cursoDeInformatica.estaMatriculado(a2)); // output: true

		Aluno novoAluno = new Aluno("Naila Silva", 1440);

		System.out.println(a2.equals(novoAluno));
		// enquanto n�o sobrescrito o m�todo equals() na classe Aluno, output: false!
		// Pois ir� comparar as refer�ncias dos objetos. Irei ent�o sobrescrever o
		// equals() para definir os crit�rios de compara��o (s�o iguais se nome e
		// matr�cula forem iguais).
		// AP�S -> output: true

		System.out.println(cursoDeInformatica.estaMatriculado(novoAluno));
		// enquanto n�o sobrescrito o m�todo hashCode() na classe Aluno, output: false!
		// Pois, no Curso, a cole��o de Alunos � um HashSet. Este tipo de cole��o
		// utiliza um hash internamente, para armazenar os elementos seguindo uma
		// "tabela de espalhamentos", assim o equals() ir� procurar o objeto apenas no
		// grupo relativo a aquele hash. Ou seja, ele compara apenas dentro do grupo de
		// semelhan�a. Por isso precisamos sobrescrever o m�todo hashCode() SEMPRE que
		// sobrescrevemos o equals(), para que objetos semelhantes recebam o mesmo hash.
		// � boa pr�tica MESMO QUE N�O ESTEJAMOS UTILIZANDO UM HASHSET.
		// J� que mesmo que no nosso c�digo n�o utilize nenhum Set, existem
		// diversos c�digos que o utilizam, e caso n�o sobrescrevemos este m�todo
		// podemos esbarrar em bugs n�o esperados
		// AP�S -> output: true

		System.out.println(a2.hashCode()); // Antes da sobrescrita: 1554547125 // Ap�s: -684896660
		System.out.println(novoAluno.hashCode()); // Antes da sobrescrita: 617901222 // Ap�s: -684896660

//		ALGUMAS OPERA��ES COM OS CONJUNTOS:

		Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
		Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));
		
		// union 
		Set<Integer> c = new TreeSet<>(a);
		c.addAll(b); // adiciona os elementos de b (desconsidera os repetidos) 
		System.out.println(a); // output: [0, 2, 4, 5, 6, 8, 10]
		
		// intersection
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);
		System.out.println(d); // output: [5, 6, 8, 10]
		
		// difference
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);
		System.out.println(e); // output: [0, 2, 4]

	}

}
