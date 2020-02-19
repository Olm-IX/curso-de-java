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

		String s = "�";
		System.out.println(s.codePointAt(0)); // output: 199 -> � o codepoint decimal no Unicode para a letra '�'

		Charset charset = Charset.defaultCharset();
		System.out.println(charset.displayName()); // output: windows-1252 -> � o charset padr�o do Windows

		byte[] bytes = s.getBytes(); // ser� usado o charset padr�o;
		System.out.println(bytes.length + " bytes - windows-1252 "); // output: 1 bytes - windows-1252
		String sNovo = new String(bytes, "windows-1252"); // Para usar um charset como argumento aqui � necess�rio
															// lan�ar a excess�o UnsupportedEncodingException
		System.out.println(sNovo); // output: �

		bytes = s.getBytes("UTF-16");
		System.out.println(bytes.length + " bytes - UTF-16 "); // output: 4 bytes - UTF-16
		System.out.println(new String(bytes, "windows-1252")); // output: �� �
//		Como o encoding utilizado nesse bytes acima foi o "UTF-16", que possuie 4 bytes, ao criar uma String com o 
//      windows-1252, que utuliza 1 byte, foram adicionados outros caracteres estranhos!
		System.out.println(new String(bytes, "UTF-16")); // output: �

		bytes = s.getBytes("UTF-8");
		System.out.println(bytes.length + " bytes - UTF-8 "); // output: 2 bytes - UTF-8
		System.out.println(new String(bytes, "windows-1252")); // output: Ç
//		Como o encoding utilizado nesse bytes acima foi o "UTF-8", que possuie 2 bytes, ao criar uma String com o 
//      windows-1252, que utuliza 1 byte, foram impressos dois caracteres estranhos!

		bytes = s.getBytes(StandardCharsets.US_ASCII); // Tamb�m � poss�vel usando a classe StantardCharsets
		System.out.println(bytes.length + " bytes - US_ASCII"); // output: 1 bytes - US_ASCII
		System.out.println(new String(bytes, "US-ASCII")); // output: ? -> caracter n�o encontrado na tabela ASCII

//		---- ENCODING COM JAVA.IO - SCANNER

		Scanner scanner = new Scanner(new File("contas.csv"), "UTF-8"); // � necess�rio lan�ar FileNotFoundException
//		como o arquivo contas.csv foi criado no Mac (UTF-8), se n�o tiv�ssemos definido o charset no construtor acima
//		o windows teria utilizado o charset padr�o windows-1252, e ent�o o S�rgio Lopes seria impresso como "Sérgio Lopes"!

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
        Reader isr = new InputStreamReader(fis, "UTF-8"); // O InputStreamReader � quem converte os bits em caracteres
        BufferedReader br = new BufferedReader(isr);

        String linha = br.readLine();

        while(linha != null) {

                System.out.println(linha);
                linha = br.readLine();
        }

        br.close();
        
//        ---- ENCODING COM JAVA.IO - PRINTWRITER
        
        PrintWriter pw = new PrintWriter("testeEscrita.txt", "UTF-8"); // Escrever em arquivo utilizando o padr�o UTF-8
        pw.write("� � df f ad ");
        pw.close();
       
	}
}
