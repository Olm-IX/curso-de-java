package entities;

public class BusinessAccount extends Account {
/*BUSINESSACCOUNT EXTENDE A ACCOUNT.
 * ISSO SIGNIFICA QUE A BUSINESSACCOUNT IR� HERDAR TODOS OS DADOS
 * E COMPORTAMENTOS DA ACCOUNT!
 */
	private Double loanLimit;
	
	public BusinessAccount() {
		super(); // ESSE SUPER CHAMA O CONSTRUTOR PADR�O DA ACCOUNT
				 // SE FOR INCLU�DA UMA LOGICA NO CONSTRUTOR PADR�O DA ACCOUNT,
				// SER� TAMB�M EXECUTADA PELA BUSINESS ACCOUNT
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance); //O SUPPER IR� APROVEITAR OS ARGUMENTOS DO CONSTRUTOR
										// COM ARGUMENTOS DA CLASSE ACCOUNT! NO GENERATE CONSTRUCTOR
										// USING FIELDS D� PARA SELECIONAR L� EM CIMA OS ATRIBUTOS
										// DA SUPER CLASSE.
		this.loanLimit = loanLimit;
	}
	
	@Override
	public final void withdraw (double amount) { // SOBREPOSI��O DO M�TODO WITHDRAW
		super.withdraw(amount); // VAI EXECUTAR O M�TODO NORMAL QUE T� NA SUPERCLASSE ACCOUNT!
		balance -=2.0; // E DEPOIS DESCONTAR MAIS 2!
	}
	
	// A PALAVRA FINAL NO M�TODO EVITA QUE ELE SEJA SOBREPOSTO!!
	// GERALMENTE CONV�M ACRESCENTAR FINAL EM M�TODOS SOBREPOSTOS, COMO O ACIMA,
	// POIS SOBREPOSI��ES M�LTIPLAS S�O CONFUSAS E PODEM SER UMA PORTA DE ENTRADA
	// PARA INCONSIST�NCIAS!

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}
	
	public void loan(double amount) {
		if (amount <= loanLimit) {
			balance += amount - 10.0;
		}
	}
}