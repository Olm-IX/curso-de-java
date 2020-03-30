//Faça um programa para ler um arquivo contendo funcionários (nome e salário) no
//formato .csv, armazenando-os em uma lista. Depois, ordenar a lista por nome e mostrar
//o resultado na tela. Nota: o caminho do arquivo pode ser informado "hardcode".
//Maria Brown,4300.00
//Alex Green,3100.00
//Bob Grey,3100.00
//Anna White,3500.00
//Alex Black,2450.00
//Eduardo Rose,4390.00
//Willian Red,2900.00
//Marta Blue,6100.00
//Alex Brown,5000.00

package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TryWithResources {

	public static void main(String[] args) {

		List<ClasseTeste> lista = new LinkedList<>();

		try (var br = new BufferedReader(new FileReader("arquivo.csv"))) {

			String linha = br.readLine();

			while (linha != null) {
//				String[] separado = linha.split(",");
//				lista.add(new ClasseTeste(separado[0], Double.valueOf(separado[1])));
				var sc = new Scanner(linha);
				sc.useDelimiter(",");
				lista.add(new ClasseTeste(sc.next(), Double.valueOf(sc.next())));
				sc.close();
				linha = br.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lista.sort(Comparator.comparing(ClasseTeste::getFuncionario));
		
		lista.forEach(x -> System.out.println(x.getFuncionario() + ", " + x.getSalario()));

	}

}
