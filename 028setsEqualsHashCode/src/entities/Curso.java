package entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Curso {

	private String nome;
	private List<Aula> aulas = new LinkedList<Aula>();
	private Set<Aluno> alunos = new HashSet<>();

	public Curso(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}

	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}
	
	/**
	 * @return a soma do tempo de todas as aulas
	 */
	public int getTempoTotal() {
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}

	/**
	 * Cadastra uma aula no curso
	 */
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}

	/**
	 * matricula um aluno no curso
	 */
	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	/**
	 * @return true se o aluno está matriculado, false se não está
	 */
	public boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

}
