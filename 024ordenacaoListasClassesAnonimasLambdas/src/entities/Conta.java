package entities;

public class Conta implements Comparable<Conta>{
	
	private Cliente cliente;
	private Double saldo;
	private int agencia;
	private int conta;
	
	public Conta(int agencia, int conta, Double saldo, Cliente cliente) {
		this.agencia = agencia;
		this.conta = conta;
		this.saldo = saldo;
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public int getConta() {
		return conta;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Agência: ");
		sb.append(this.agencia);
		sb.append(", Conta ");
		sb.append(this.conta);
		sb.append(", Saldo: ");
		sb.append(this.saldo);
		sb.append(", Cliente: ");
		sb.append(this.cliente);
		return String.valueOf(sb);
	}

	@Override
	public int compareTo(Conta outraConta) { 
		// Organizando pelo número da conta. Se a outra conta tiver o número maior, retorna
		// um valor negativo. Se forem iguais, retorna zero. Se tiver o número menor,
		// retorna um valor positivo.
		return this.conta - outraConta.conta;
	}
	
}
