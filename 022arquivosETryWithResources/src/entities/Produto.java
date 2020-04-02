package entities;

/**
 * Classe Teste para ser usada no application.FileWriter.java
 */
public class Produto {
	
	private String nome;
	private Double preco;
	private Integer quantidade;
	private Double precoTotal;
	
	public Produto(String nome, Double preco, Integer quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}	
	
	public String getNome() {
		return nome;
	}

	public Double getPrecoTotal() {
		return this.preco*quantidade;
	}

	@Override
		public String toString() {
			return nome + preco + quantidade;
		}

}
