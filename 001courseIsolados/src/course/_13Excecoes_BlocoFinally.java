package course;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class _13Excecoes_BlocoFinally {

	public static void main(String[] args) {

		File file = new File("C:\\temp\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} 
		catch (IOException e) {
			System.out.println("Error opening file: " + e.getMessage());
		} 
		finally { // O BLOCO FINALLY SERÁ EXECUTADO, TENDO OU NÃO A EXCEÇÃO
			if (sc != null) {
				sc.close();
			}
		}

	}

}
