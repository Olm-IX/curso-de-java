package application;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import entities.Aluno;

public class TestaTreeSetELinkedHashSet {

	public static void main(String[] args) {

		Set<Aluno> conjuntoDeAlunos = new TreeSet<>();
//		TreeSet guarda os objetos em sua ordem natual. S� � poss�vel implementar com objetos 
//		que implementam Comparable. Mesmo assim, n�o � poss�vel utilizar o .get(�ndice), ou
//		outros m�todos que utilizem o �ndice. Apenas, ao percorrer a lista com um foreach, os
//		elementos vir�o em sua ordem natural.

		conjuntoDeAlunos.add(new Aluno("Miguel", 46859));
		conjuntoDeAlunos.add(new Aluno("Vitor", 64852));
		conjuntoDeAlunos.add(new Aluno("Cl�udio", 19963));
		conjuntoDeAlunos.add(new Aluno("Bruno", 23798));
		conjuntoDeAlunos.add(new Aluno("Ana", 98524));

		conjuntoDeAlunos.forEach(aluno -> System.out.println(aluno));
//		output:
//			Ana        - 98524
//			Bruno      - 23798
//			Cl�udio    - 19963
//			Miguel     - 46859
//			Vitor      - 64852
		System.out.println(System.lineSeparator());

		Set<Aluno> outroConjuntoDeAlunos = new LinkedHashSet<>();
//		LinkedHashSet guarda a ordem em que os objetos foram adicionados ao conjunto. 
//		Novamente, n�o � poss�vel utilizar o .get(�ndice), ou outros m�todos que utilizem o �ndice. 
//		Apenas, ao percorrer a lista com um foreach, os elementos vir�o na ordem em que foram adicionados.

		outroConjuntoDeAlunos.add(new Aluno("Miguel", 46859));
		outroConjuntoDeAlunos.add(new Aluno("Vitor", 64852));
		outroConjuntoDeAlunos.add(new Aluno("Cl�udio", 19963));
		outroConjuntoDeAlunos.add(new Aluno("Bruno", 23798));
		outroConjuntoDeAlunos.add(new Aluno("Ana", 98524));

//		OBS.: O m�todo .forEach(), e a sintaxe do for each, foram introduzidas no java 8 e java 5,
//		respectivamente, ent�o antes disso como percorrer o conjunto, j� que n�o � poss�vel
//		utilizar o .get(�ndice)? Era utilizado um Iterator. Hoje os Iterators n�o s�o mais
//		muito utilizados.
		Iterator<Aluno> iteradorDeAlunos = outroConjuntoDeAlunos.iterator();
		while (iteradorDeAlunos.hasNext()) {
			System.out.println(iteradorDeAlunos.next());
		}
//		output:
//			Miguel     - 46859
//			Vitor      - 64852
//			Cl�udio    - 19963
//			Bruno      - 23798
//			Ana        - 98524

	}

}
