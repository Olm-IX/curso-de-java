package application;

import entities.Aluno;
import entities.Curso;

public class Program {

	public static void main(String[] args) {

		Curso cursoDeInformatica = new Curso("Informática");

		Aluno a1 = new Aluno("Luiz Quintas", 1080);
		Aluno a2 = new Aluno("Naila Silva", 1440);

		cursoDeInformatica.matricula(a1);
		cursoDeInformatica.matricula(a2);

		System.out.println(cursoDeInformatica.estaMatriculado(a2)); // output: true

		Aluno novoAluno = new Aluno("Naila Silva", 1440);

		System.out.println(a2.equals(novoAluno));
		// enquanto não sobrescrito o método equals() na classe Aluno, output: false!
		// Pois irá comparar as referências dos objetos. Irei então sobrescrever o
		// equals() para definir os critérios de comparação (são iguais se nome e
		// matrícula forem iguais).
		// APÓS -> output: true

		System.out.println(cursoDeInformatica.estaMatriculado(novoAluno));
		// enquanto não sobrescrito o método hashCode() na classe Aluno, output: false!
		// Pois, no Curso, a coleção de Alunos é um HashSet. Este tipo de coleção
		// utiliza um hash internamente, para armazenar os elementos seguindo uma
		// "tabela de espalhamentos", assim o equals() irá procurar o objeto apenas no
		// grupo relativo a aquele hash. Ou seja, ele compara apenas dentro do grupo de
		// semelhança. Por isso precisamos sobrescrever o método hashCode() SEMPRE que
		// sobrescrevemos o equals(), para que objetos semelhantes recebam o mesmo hash.
		// É boa prática MESMO QUE NÃO ESTEJAMOS UTILIZANDO UM HASHSET.
		// Já que mesmo que no nosso código não utilize nenhum Set, existem
		// diversos códigos que o utilizam, e caso não sobrescrevemos este método
		// podemos esbarrar em bugs não esperados
		// APÓS -> output: true

		System.out.println(a2.hashCode()); // Antes da sobrescrita: 1554547125 // Após: -684896660
		System.out.println(novoAluno.hashCode()); // Antes da sobrescrita: 617901222 // Após: -684896660

	}

}
