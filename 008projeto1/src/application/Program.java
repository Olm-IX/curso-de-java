package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Conta;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Conta conta;

		System.out.print("Enter account number: ");
		int numeroConta = sc.nextInt();
		sc.nextLine(); // LIMPEZA DE STREAM
		
		System.out.print("Enter account holder: ");
		String nome = sc.nextLine();
		
		System.out.print("Is there a initial deposit (y/n): ");
		char opcao = sc.next().charAt(0);
	
		while (opcao != 'y' && opcao != 'n') {
			System.out.print("Invalid option. Is there a initial deposit? (y/n): ");
			opcao = sc.next().charAt(0);
		}
		
		if (opcao == 'y') {
			System.out.print("Enter initial deposit value: ");
			double depositoInicial = sc.nextDouble();
			conta = new Conta (numeroConta, nome, depositoInicial);
		} else {
			conta = new Conta (numeroConta, nome);
		}
		
		System.out.printf("%nAccount data: %n" + conta + "%n%n");
		
		System.out.print("Enter a deposit value: ");
		Double montante = sc.nextDouble();
		conta.deposit(montante);
		
		System.out.printf("Updated account data: %n" + conta + "%n%n");
		
		System.out.print("Enter a withdraw value: ");
		montante = sc.nextDouble();
		conta.withdraw(montante);
		
		System.out.printf("Updated account data: %n" + conta + "%n%n");
		sc.close();
	}


}
