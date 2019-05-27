package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.ErroLimiteException;
import model.exceptions.ErroSaldoException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw Limit: ");
			Double withdrawLimit = sc.nextDouble();

			Account account = new Account(number, holder, balance, withdrawLimit);
			System.out.println();

			System.out.print("Enter amount for withdraw: ");
			Double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.print("New balance: " + account.getBalance());
		} catch (ErroLimiteException e) {
			System.out.println("Withdraw Error: " + e.getMessage());
		} catch (ErroSaldoException e) {
			System.out.println("Withdraw Error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected Error");
		}
		sc.close();
	}
}
