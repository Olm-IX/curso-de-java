//Fazer um programa para ler os dados (nome, e-mail e sal�rio) de funcion�rios a partir de um arquivo
//em formato .csv. Em seguida mostrar, em ordem alfab�tica, o e-mail dos funcion�rios cujo sal�rio seja 
//superior ao sal�rio m�dio. Mostrar tamb�m a soma dos sal�rios dos funcion�rios cujo nome come�a com 
//a letra 'M'.

//Arquivo in.txt:
//	Maria,maria@gmail.com,3200.00
//	Alex,alex@gmail.com,1900.00
//	Marcco,marco@gmail.com,1700.00
//	Bob,bob@gmail.com,3500.00
//	Anna,anna@gmail.com,2800.00

package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionario;

public class ExercicioPipeline {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o caminho do arquivo: "); // in.txt
		String path = sc.nextLine();
		sc.close();
		List<Funcionario> listaDeFuncionarios = new ArrayList<>();

		try (Scanner fileScanner = new Scanner(new File(path))) {

			while (fileScanner.hasNext()) {
				String[] linha = fileScanner.nextLine().split(",");
				listaDeFuncionarios.add(new Funcionario(linha[0], linha[1], Double.valueOf(linha[2])));
			}
		
			Double mediaSalarial = listaDeFuncionarios.stream()
					.map(Funcionario::getSalario)
					.reduce(0.0, Double::sum)
					/ listaDeFuncionarios.size();

			System.out.println("A m�dia salarial �: " + mediaSalarial); // output: 2620.0
			System.out.println("E-mail dos funcion�rios que ganham mais que a M�dia: ");
			listaDeFuncionarios.stream()
					.filter(x -> x.getSalario() > mediaSalarial)
					.collect(Collectors.toList())
					.forEach(x -> System.out.println(x.getEmail()));
//						output: 
//							maria@gmail.com
//							bob@gmail.com
//							anna@gmail.com

			System.out.println("Soma dos sal�rios dos funcion�rios cujos nomes come�am com 'M': "
					+ listaDeFuncionarios.stream()
						.filter(x -> x.getNome().charAt(0) == 'M')
						.map(Funcionario::getSalario)
						.reduce(0.0, Double::sum)); // output: 4900.0

//			Criando uma nova lista com os nomes dos funcion�rios que ganham abaixo da media, em 
//			ordem decrescente do nome
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()); // ordem crescente
			List<String> nomes = listaDeFuncionarios.stream()
					.filter(x -> x.getSalario() < mediaSalarial)
					.map(Funcionario::getNome).sorted(comp.reversed()) // Inverte o Comparator, ordem decrescente!
					.collect(Collectors.toList());
			nomes.forEach(System.out::println);
//				output:
//					Marco
//					Alex
		
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
