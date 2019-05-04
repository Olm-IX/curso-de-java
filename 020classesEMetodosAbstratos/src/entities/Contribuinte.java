package entities;

// CLASSE ABSTRATA! ISSO SIGNIFICA QUE N�O � POSS�VEL INSTANCIAR UM OBJETO DO TIPO "CONTRIBUINTE"
// OBRIGATORIAMENTE TER� QUE INSTANCIAR AS SUBCLASSES!
// Contribuinte a = new Contribuinte(); ISSO VAI DAR ERRO
// Contribuinte a = new PessoaFisica(); ISSO N�O VAI DAR ERRO!

public abstract class Contribuinte {
	private String nome;
	private Double rendaAnual;
	
	public Contribuinte () {
	}
	
	public Contribuinte (String nome, Double renda) {
		this.nome = nome;
		this.rendaAnual = renda;
	}
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getRendaAnual() {
		return rendaAnual;
	}

	public void setRendaAnual(Double renda) {
		this.rendaAnual = renda;
	}

	// M�TODO ABSTRATO
	// S� PODEM SER CRIADOS EM CLASSES ABSTRATAS!
	// N�O POSSUEM IMPLEMENTA��O, AS SUBCLASSES TER�O QUE OBRIGATORIAMENTE SOBRESCREVE-LO
	public abstract Double impostoPago();
	
	 public String toString() {
		 StringBuilder sb = new StringBuilder();
		 sb.append(nome);
		 sb.append(": $");
		 sb.append(String.format("%.2f", impostoPago()));
		 return sb.toString();
	 }

}