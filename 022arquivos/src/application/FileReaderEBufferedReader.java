package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEBufferedReader {
	public static void main(String[] args) {
		String path = "E:\\Projetos\\ws-curso-de-java\\022arquivos\\teste.txt";
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr); // O FileReader é instanciado dentro do BufferedReader!
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
