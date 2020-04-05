package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

//		Cria uma lista de elementos já pré-definidos:
		List<String> lista = Arrays.asList("foo", "bar", "baz");
//		lista.add("adsf"); // Lança uma java.lang.UnsupportedOperationException (AbstractList)
		lista.set(1, "Naila");
		System.out.println(lista); // output: [foo, Naila, baz]

//		JAVA 9 - Lista não modificável:
		List<String> list = List.of("foo", "bar", "baz");
//		list.add("teste"); // Lança uma java.lang.UnsupportedOperationException (Immutable Collecion)
		System.out.println(list); // output: [foo, bar, baz]
//		Isso é novidade do Java 9, antes era feito assim:
//			List<String> list2 = new ArrayList<>();
//			list2.add("foo");
//			list2.add("bar");
//			list2.add("baz");
//			list2 = Collections.unmodifiableList(list2);
//		Java 9 Collection Factory Methods
//			https://www.baeldung.com/java-9-collections-factory-methods
//		What is the difference between List.of and Arrays.asList?
//			https://stackoverflow.com/questions/46579074/what-is-the-difference-between-list-of-and-arrays-aslist

//		Usando classes anônimas:
//		List<String> list2 = Collections.unmodifiableList(new ArrayList<String>() {
//			{
//				add("foo");	add("bar");	add("baz");
//			}
//		});

		System.out.print("How many employees will be registered? ");
		int quantidadeDeFuncionarios = sc.nextInt();

		List<Funcionario> listaDeFuncionarios = new ArrayList<>();

		for (int i = 1; i <= quantidadeDeFuncionarios; i++) {
			System.out.println();
			System.out.println("Employee #" + i);
			System.out.print("Id: ");
			int id = sc.nextInt();
			boolean verificacao = false;
			for (Funcionario obj : listaDeFuncionarios) {
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
