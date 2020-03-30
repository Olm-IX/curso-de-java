package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileEScanner {

	public static void main(String[] args) {

		File file = new File("E:\\Projetos\\ws-curso-de-java\\022arquivos\\teste.txt"); // barra dupla pois a barra é prefixo de caracteres especiais
		Scanner sc = null;
		// A leitura do arquivo txt pode gerar uma IOException, por isso colocar dentro do bloco try
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally { // O fechamento do recurso deve ser no bloco finally, pois aí será fechado independente se o bloco try deu certo ou não
			if (sc != null) {
				sc.close();
			}
		}
	}
}
