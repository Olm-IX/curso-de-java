//Na contagem de votos de uma eleição, são gerados vários registros
//de votação contendo o nome do candidato e a quantidade de votos
//(formato .csv) que ele obteve em uma urna de votação. Você deve
//fazer um programa para ler os registros de votação a partir de um
//arquivo, e daí gerar um relatório consolidado com os totais de cada
//candidato.

package applicatin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file path: "); // D:\Documentos\Projetos\ws-curso-de-java\030maps\votes.csv
		String path = sc.nextLine();
		sc.close();

		Map<String, Integer> result = new HashMap<>();

		try (var br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				Scanner lineScanner = new Scanner(line);
				lineScanner.useDelimiter(",");
				String candidate = lineScanner.next();
				int votes = lineScanner.nextInt();
				lineScanner.close();
				
				if(result.containsKey(candidate)) {
					result.put(candidate, result.get(candidate) + votes);
				} else {
					result.put(candidate, votes);
				}
	
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		for (String key : result.keySet()) {
			System.out.println(key + ": " + result.get(key));
		}
	}
}
