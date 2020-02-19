package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {

		String s = "Ç";
		System.out.println(s.codePointAt(0)); // output: 199 -> é o codepoint decimal no Unicode para a letra 'Ç'

		Charset charset = Charset.defaultCharset();
		System.out.println(charset.displayName()); // output: windows-1252 -> é o charset padrão do Windows

		byte[] bytes = s.getBytes(); // será usado o charset padrão;
		System.out.println(bytes.length + " bytes - windows-1252 "); // output: 1 bytes - windows-1252
		String sNovo = new String(bytes, "windows-1252"); // Para usar um charset como argumento aqui é necessário
															// lançar a excessão UnsupportedEncodingException
		System.out.println(sNovo); // output: Ç

		bytes = s.getBytes("UTF-16");
		System.out.println(bytes.length + " bytes - UTF-16 "); // output: 4 bytes - UTF-16
		System.out.println(new String(bytes, "windows-1252")); // output: þÿ Ç
//		Como o encoding utilizado nesse bytes acima foi o "UTF-16", que possuie 4 bytes, ao criar uma String com o 
//      windows-1252, que utuliza 1 byte, foram adicionados outros caracteres estranhos!
		System.out.println(new String(bytes, "UTF-16")); // output: Ç

		bytes = s.getBytes("UTF-8");
		System.out.println(bytes.length + " bytes - UTF-8 "); // output: 2 bytes - UTF-8
		System.out.println(new String(bytes, "windows-1252")); // output: Ã‡
//		Como o encoding utilizado nesse bytes acima foi o "UTF-8", que possuie 2 bytes, ao criar uma String com o 
//      windows-1252, que utuliza 1 byte, foram impressos dois caracteres estranhos!

		bytes = s.getBytes(StandardCharsets.US_ASCII); // Também é possível usando a classe StantardCharsets
		System.out.println(bytes.length + " bytes - US_ASCII"); // output: 1 bytes - US_ASCII
		System.out.println(new String(bytes, "US-ASCII")); // output: ? -> caracter não encontrado na tabela ASCII

//		---- ENCODING COM JAVA.IO - SCANNER

		Scanner scanner = new Scanner(new File("contas.csv"), "UTF-8"); // é necessário lançar FileNotFoundException
//		como o arquivo contas.csv foi criado no Mac (UTF-8), se não tivéssemos definido o charset no construtor acima
//		o windows teria utilizado o charset padrão windows-1252, e então o Sérgio Lopes seria impresso como "SÃ©rgio Lopes"!

		while (scanner.hasNextLine()) {
			String linha = scanner.nextLine();
			// System.out.println(linha);

			Scanner linhaScanner = new Scanner(linha);
			linhaScanner.useLocale(Locale.US);
			linhaScanner.useDelimiter(",");

			String tipoConta = linhaScanner.next();
			int agencia = linhaScanner.nextInt();
			int numero = linhaScanner.nextInt();
			String titular = linhaScanner.next();
			double saldo = linhaScanner.nextDouble();

			System.out.format(new Locale("pt", "BR"), "%s - %04d0%08d, %20s: %08.2f %n", 
											tipoConta, agencia, numero,	titular, saldo);

			linhaScanner.close();
		}
		scanner.close();
		
//		---- ENCODING COM JAVA.IO - INPUT STREAM READER
        
		InputStream fis = new FileInputStream("contas.csv");
        Reader isr = new InputStreamReader(fis, "UTF-8"); // O InputStreamReader é quem converte os bits em caracteres
        BufferedReader br = new BufferedReader(isr);

        String linha = br.readLine();

        while(linha != null) {

                System.out.println(linha);
                linha = br.readLine();
        }

        br.close();
        
//        ---- ENCODING COM JAVA.IO - PRINTWRITER
        
        PrintWriter pw = new PrintWriter("testeEscrita.txt", "UTF-8"); // Escrever em arquivo utilizando o padrão UTF-8
        pw.write("É Ç df f ad ");
        pw.close();
       
	}
}
