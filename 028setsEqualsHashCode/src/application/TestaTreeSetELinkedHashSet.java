package application;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import entities.Aluno;

public class TestaTreeSetELinkedHashSet {

	public static void main(String[] args) {

		Set<Aluno> conjuntoDeAlunos = new TreeSet<>();
//		TreeSet guarda os objetos em sua ordem natual. Só é possível implementar com objetos 
//		que implementam Comparable. Mesmo assim, não é possível utilizar o .get(índice), ou
//		outros métodos que utilizem o índice. Apenas, ao percorrer a lista com um foreach, os
//		elementos virão em sua ordem natural.

		conjuntoDeAlunos.add(new Aluno("Miguel", 46859));
		conjuntoDeAlunos.add(new Aluno("Vitor", 64852));
		conjuntoDeAlunos.add(new Aluno("Cláudio", 19963));
		conjuntoDeAlunos.add(new Aluno("Bruno", 23798));
		conjuntoDeAlunos.add(new Aluno("Ana", 98524));

		conjuntoDeAlunos.forEach(aluno -> System.out.println(aluno));
//		output:
//			Ana        - 98524
//			Bruno      - 23798
//			Cláudio    - 19963
//			Miguel     - 46859
//			Vitor      - 64852
		System.out.println(System.lineSeparator());

		Set<Aluno> outroConjuntoDeAlunos = new LinkedHashSet<>();
//		LinkedHashSet guarda a ordem em que os objetos foram adicionados ao conjunto. 
//		Novamente, não é possível utilizar o .get(índice), ou outros métodos que utilizem o índice. 
//		Apenas, ao percorrer a lista com um foreach, os elementos virão na ordem em que foram adicionados.

		outroConjuntoDeAlunos.add(new Aluno("Miguel", 46859));
		outroConjuntoDeAlunos.add(new Aluno("Vitor", 64852));
		outroConjuntoDeAlunos.add(new Aluno("Cláudio", 19963));
		outroConjuntoDeAlunos.add(new Aluno("Bruno", 23798));
		outroConjuntoDeAlunos.add(new Aluno("Ana", 98524));

//		OBS.: O método .forEach(), e a sintaxe do for each, foram introduzidas no java 8 e java 5,
//		respectivamente, então antes disso como percorrer o conjunto, já que não é possível
//		utilizar o .get(índice)? Era utilizado um Iterator. Hoje os Iterators não são mais
//		muito utilizados.
		Iterator<Aluno> iteradorDeAlunos = outroConjuntoDeAlunos.iterator();
		while (iteradorDeAlunos.hasNext()) {
			System.out.println(iteradorDeAlunos.next());
		}
//		output:
//			Miguel     - 46859
//			Vitor      - 64852
//			Cláudio    - 19963
//			Bruno      - 23798
//			Ana        - 98524

	}

}
