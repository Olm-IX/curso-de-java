    
package entities;

public final class SavingsAccount extends Account {
	//A PALAVRA FINAL IMPEDE QUE ESSA CLASSE SEJA HERDADA
	//CLASSES FINAL S�O EXECUTADAS MAIS RAPIDAMENTE, MAIOR PERFORMANCE!
	
	private Double interestRate;
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
		super(number, holder, balance);
		this.interestRate = interestRate;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void updateBalance() {
		balance += balance * interestRate;
	}
	
	// ABAIXO � UMA SOBREPOSI��O DO M�TODO, PORQUE H� O MESMO NA CLASSE ACCOUNT!
	// NESSE CASO, USAR A PALAVRA "@Override"
	
	@Override
	public final void withdraw(double amount) {
		balance -= amount;
	}
	
	// A PALAVRA FINAL NO M�TODO EVITA QUE ELE SEJA SOBREPOSTO!!
	// GERALMENTE CONV�M ACRESCENTAR FINAL EM M�TODOS SOBREPOSTOS, COMO O ACIMA,
	// POIS SOBREPOSI��ES M�LTIPLAS S�O CONFUSAS E PODEM SER UMA PORTA DE ENTRADA
	// PARA INCONSIST�NCIAS!
}