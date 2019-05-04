package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Locale.setDefault(Locale.US);
		
		List<Contribuinte> listaDeContribuintes = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int numberOfTaxPayers = sc.nextInt();
		
		for (int i=1; i<= numberOfTaxPayers; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Annual income: ");
			Double anualIncome = sc.nextDouble();
			if (type == 'i') {
				System.out.print("Health expenditures: ");
				Double gastosSaude = sc.nextDouble();
				listaDeContribuintes.add(new PessoaFisica(nome, anualIncome, gastosSaude));
			}else{
				System.out.print("Number of employees: ");
				int numeroFuncionarios = sc.nextInt();
				listaDeContribuintes.add(new PessoaJuridica(nome, anualIncome, numeroFuncionarios));
			}
		}
		System.out.println();
		System.out.println("TAXES PAID: ");
		for (Contribuinte contribuinte : listaDeContribuintes) {
			System.out.println(contribuinte);
		}
		System.out.println();
		Double totalTaxes = 0.0;
		for (Contribuinte contribuinte: listaDeContribuintes){
			totalTaxes += contribuinte.impostoPago();
		}
		System.out.printf("TOTAL TAXES: $%.2f", totalTaxes);
		
		sc.close();
	}

}
