    
package entities;

public final class SavingsAccount extends Account {
	//A PALAVRA FINAL IMPEDE QUE ESSA CLASSE SEJA HERDADA
	//CLASSES FINAL SÃO EXECUTADAS MAIS RAPIDAMENTE, MAIOR PERFORMANCE!
	
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
	
	// ABAIXO É UMA SOBREPOSIÇÃO DO MÉTODO, PORQUE HÁ O MESMO NA CLASSE ACCOUNT!
	// NESSE CASO, USAR A PALAVRA "@Override"
	
	@Override
	public final void withdraw(double amount) {
		balance -= amount;
	}
	
	// A PALAVRA FINAL NO MÉTODO EVITA QUE ELE SEJA SOBREPOSTO!!
	// GERALMENTE CONVÉM ACRESCENTAR FINAL EM MÉTODOS SOBREPOSTOS, COMO O ACIMA,
	// POIS SOBREPOSIÇÕES MÚLTIPLAS SÃO CONFUSAS E PODEM SER UMA PORTA DE ENTRADA
	// PARA INCONSISTÊNCIAS!
}