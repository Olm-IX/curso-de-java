package entities;

public class Pessoa {

	private String nome;
	private int idade;
	private String nacionalidade;
		
	public Pessoa(String nome, int idade, String nacionalidade) {
		this.nome = nome;
		this.idade = idade;
		this.nacionalidade = nacionalidade;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public static boolean isOldStaticPredicate (Pessoa p) {
		return p.getIdade() >= 60;
	}
	
	public boolean isOldNonStaticPredicate () {
		return this.idade >= 60;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
