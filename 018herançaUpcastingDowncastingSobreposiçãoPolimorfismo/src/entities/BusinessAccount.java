package entities;

public class BusinessAccount extends Account {
/*BUSINESSACCOUNT EXTENDE A ACCOUNT.
 * ISSO SIGNIFICA QUE A BUSINESSACCOUNT IRÁ HERDAR TODOS OS DADOS
 * E COMPORTAMENTOS DA ACCOUNT!
 */
	private Double loanLimit;
	
	public BusinessAccount() {
		super(); // ESSE SUPER CHAMA O CONSTRUTOR PADRÃO DA ACCOUNT
				 // SE FOR INCLUÍDA UMA LOGICA NO CONSTRUTOR PADRÃO DA ACCOUNT,
				// SERÁ TAMBÉM EXECUTADA PELA BUSINESS ACCOUNT
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance); //O SUPPER IRÁ APROVEITAR OS ARGUMENTOS DO CONSTRUTOR
										// COM ARGUMENTOS DA CLASSE ACCOUNT! NO GENERATE CONSTRUCTOR
										// USING FIELDS DÁ PARA SELECIONAR LÁ EM CIMA OS ATRIBUTOS
										// DA SUPER CLASSE.
		this.loanLimit = loanLimit;
	}
	
	@Override
	public final void withdraw (double amount) { // SOBREPOSIÇÃO DO MÉTODO WITHDRAW
		super.withdraw(amount); // VAI EXECUTAR O MÉTODO NORMAL QUE TÁ NA SUPERCLASSE ACCOUNT!
		balance -=2.0; // E DEPOIS DESCONTAR MAIS 2!
	}
	
	// A PALAVRA FINAL NO MÉTODO EVITA QUE ELE SEJA SOBREPOSTO!!
	// GERALMENTE CONVÉM ACRESCENTAR FINAL EM MÉTODOS SOBREPOSTOS, COMO O ACIMA,
	// POIS SOBREPOSIÇÕES MÚLTIPLAS SÃO CONFUSAS E PODEM SER UMA PORTA DE ENTRADA
	// PARA INCONSISTÊNCIAS!

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