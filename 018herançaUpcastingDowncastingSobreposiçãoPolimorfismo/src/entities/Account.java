package entities;

public class Account {
// public final class Account {
// SE ESTIVESSE ESCRITO ASSIM, ESSA CLASSE N�O PODERIA SER HERDADA!
// N�O DARIA PARA CRIAR AS SUBCLASSES BUSINESSACCOUNT E SAVINGSACCOUNT
// CLASSES FINAL S�O EXECUTADAS MAIS RAPIDAMENTE, MAIOR PERFORMANCE!

	private Integer number;
	private String holder;
	protected Double balance;
		
	public Account() {
	}
	
	public Account(Integer number, String holder, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void withdraw(double amount) {
	// public void final withdraw(double amount) { 
	// SE ESTIVESSE ESCRITO ASSIM, N�O DARIA PARA CRIAR AS SOBREPOSI��ES DO M�TODO NAS SUBCLASSES
				
		balance -= amount + 5.0;
	}

	public void deposit(double amount) {
		balance += amount;
	}
}