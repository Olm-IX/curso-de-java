package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class InputStreamReaderBufferedReader {

	public static void main(String[] args) throws IOException {
	
//		Foi criado um arquivo "Texto.txt" no diretório do projeto
		
//		Socket socket = new Socket().getInputStream();
		
//		Leitura do arquivo "Texto.txt"
		InputStream fis = new FileInputStream("Texto.txt"); // System.in; // socket.getInputStream();
		Reader isd = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isd);

//		Escrita em outro arquivo
		OutputStream fos = new FileOutputStream("Novo Texto Copiado.txt"); // System.out; // socket.getOutputStream()
		Writer osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
//		Copia todas as linhas do arquivo "Texto.txt" para o novo arquivo!
		String linha = br.readLine();
		while (linha != null) {
			bw.write(linha);
			bw.newLine();
			linha = br.readLine();
		}
		
		br.close();
		bw.close();
		
//		Leitura do novo arquivo "Novo Texto Copiado.txt"
		InputStream fis2 = new FileInputStream("Novo Texto Copiado.txt");
		Reader isd2 = new InputStreamReader(fis2);
		BufferedReader br2 = new BufferedReader(isd2);
		
//		Escrita no console!
		OutputStream fos2 = System.out;
		Writer osw2 = new OutputStreamWriter(fos2);
		BufferedWriter bw2 = new BufferedWriter(osw2);
		
//		Imprime no console o texto do "Novo Texto Copiado.txt"
		linha = br2.readLine();
		while (linha != null) {
			bw2.write(linha + "\n");
			linha = br2.readLine();
		}
		bw2.flush();
		
		br2.close();
		
//		Leitura do teclado
		InputStream fis3 = System.in;
		Reader isd3 = new InputStreamReader(fis3);
		BufferedReader br3 = new BufferedReader(isd3);
		
//		Imprime o que foi lido no teclado no console
		System.out.println("\nDigite algo");
		bw2.write(br3.readLine());
		bw2.flush();
		
//		Da mesma maneira, daria para armazenar o que foi lido no teclado em um novo arquivo,
//		usando o new FileInputStream("Nome do arquivo");
		
		bw2.close();
		br3.close();
	}

}