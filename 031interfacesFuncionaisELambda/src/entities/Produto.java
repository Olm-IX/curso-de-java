package entities;

public class Produto {

	private String nome;
	private double preco;
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public static void aumentaPrecoConsumerEstatico(Produto produto) {
		produto.setPreco(produto.getPreco() * 1.1);
	}
	
	public void aumentaPrecoConsumerNaoEstatico() {
		this.preco *= 1.1;
	}
	
	public static String nomeMaiusculoEstatico(Produto produto) {
		return produto.getNome().toUpperCase();
	}
	
	public String nomeMaiusculoNaoEstatico() {
		return this.nome.toUpperCase();
	}
		
	@Override
	public String toString() {
		return String.format("%s - %.2f", this.nome, this.preco);
	}
	
	
	
}
