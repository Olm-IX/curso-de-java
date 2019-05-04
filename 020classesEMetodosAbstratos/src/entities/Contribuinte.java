package entities;

// CLASSE ABSTRATA! ISSO SIGNIFICA QUE NÃO É POSSÍVEL INSTANCIAR UM OBJETO DO TIPO "CONTRIBUINTE"
// OBRIGATORIAMENTE TERÁ QUE INSTANCIAR AS SUBCLASSES!
// Contribuinte a = new Contribuinte(); ISSO VAI DAR ERRO
// Contribuinte a = new PessoaFisica(); ISSO NÃO VAI DAR ERRO!

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

	// MÉTODO ABSTRATO
	// SÓ PODEM SER CRIADOS EM CLASSES ABSTRATAS!
	// NÃO POSSUEM IMPLEMENTAÇÃO, AS SUBCLASSES TERÃO QUE OBRIGATORIAMENTE SOBRESCREVE-LO
	public abstract Double impostoPago();
	
	 public String toString() {
		 StringBuilder sb = new StringBuilder();
		 sb.append(nome);
		 sb.append(": $");
		 sb.append(String.format("%.2f", impostoPago()));
		 return sb.toString();
	 }

}