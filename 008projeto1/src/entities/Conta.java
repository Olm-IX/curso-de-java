package entities;

public class Conta {
	
	private int numeroConta;
	private String nome;
	private Double saldo;
	
	// CONSTRUTORES 
	
	public Conta(int numeroConta, String nome, Double depositoInicial) {
		this.numeroConta = numeroConta;
		this.nome = nome;
		deposit(depositoInicial); // FICA MELHOR CONCENTRANDO TODAS AS OPERA��ES DE DEPOSITO NESSE METODO!
		// ASSIM, SE O BANCO PRECISAR MODIFICAR A REGRA DE NEG�CIO NO DEP�SITO, � S� MUDAR UM M�TODO.
	}

	public Conta(int numeroConta, String nome) {
		this.numeroConta = numeroConta;
		this.nome = nome;
		saldo = 0.0;
	}
	
	// GETTERS AND SETTERS 
	
	public int getNumeroConta() {
		return numeroConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSaldo() {
		return saldo;
	}

	// M�TODOS 
	
	public void deposit(double montante) {
		saldo += montante;
	}
	
	public void withdraw (double montante) {
		saldo -= montante + 5.00; // 5 � A TAXA DE RETIRADA
	}	
	
	public String toString() {
		return "Account "
				+ numeroConta
				+ ", Holder: "
				+ nome
				+ ", Balance: $ "
				+ String.format("%.2f", saldo);
	}
	
}
