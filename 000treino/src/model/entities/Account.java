package model.entities;

import model.exceptions.ErroLimiteException;
import model.exceptions.ErroSaldoException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance, withdrawLimit;
	
	public Account () {
	}

	public Account(Integer number, String holder, Double withdrawLimit, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
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

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit (Double amount) {
		balance += amount;
	}
	
	public void withdraw (Double amount) throws ErroSaldoException, ErroLimiteException {
		if (amount > balance) {
			throw new ErroSaldoException ("Not enought balance");
		}
		if (amount > withdrawLimit) {
			throw new ErroLimiteException ("The amount exceeds withdraw limit");
		}
		balance -= amount;
	}
	
	
	
}
