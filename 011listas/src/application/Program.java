package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int quantidadeDeFuncionarios = sc.nextInt();

		List<Funcionario> listaDeFuncionarios = new ArrayList<>();

		
		for (int i = 1; i <= quantidadeDeFuncionarios; i++) {
			System.out.println();
			System.out.println("Employee #" + i);
			System.out.print("Id: ");
			int id = sc.nextInt();
			boolean verificacao = false;
			for (Funcionario obj: listaDeFuncionarios) {
				if (obj.getId() == id) {
					verificacao = true;
				}
			}
			if (verificacao == true) {
				System.out.println("Id already exists!");
			} else {
			System.out.print("Name: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salary: ");
			double salario = sc.nextDouble();
			listaDeFuncionarios.add(new Funcionario(id, nome, salario));
		}
		}

		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();

		Funcionario func = listaDeFuncionarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

		if (func == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			Double porcentagem = sc.nextDouble();

			func.aumentoDeSalario(porcentagem);
		}

		System.out.println();
		System.out.println("List of employees:");
		for (Funcionario obj : listaDeFuncionarios) {
			System.out.println(obj);
		}

		sc.close();
	}
}
