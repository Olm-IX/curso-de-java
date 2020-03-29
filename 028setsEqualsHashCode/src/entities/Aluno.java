package entities;

public class Aluno implements Comparable<Aluno>{

	private String nome;
	private int numeroMatricula;

	public Aluno(String nome, int numeroMatricula) {
		// Programa��o defensiva!
		if (nome == null) {
			throw new NullPointerException("Nome n�o pode ser nulo");
		}
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}

	@Override
	public boolean equals(Object obj) {
		Aluno aluno = (Aluno) obj;
		return (this.nome == aluno.nome) && (this.numeroMatricula == aluno.numeroMatricula);
		// obs.: Tomar cuidado com o m�todo equals() para n�o comparar um aluno com nome
		// vazio! Melhor programar defensivamente e impedir um nome vazio j� no
		// construtor.
	}

	@Override
	public int hashCode() {
		return this.nome.hashCode();
		// A classe String j� possui um bom m�todo para gerar hashCodes!
		// E armazenar objetos com nomes semelhantes no mesmo grupo.
	}

	@Override
	public int compareTo(Aluno outroAluno) {
		return this.nome.compareTo(outroAluno.nome);
		// Interface comparable inserida para testar os TreeSets!
	}
	
	@Override
	public String toString() {
		return String.format("%-10s - ", this.nome) + this.numeroMatricula;
	}
	
}
