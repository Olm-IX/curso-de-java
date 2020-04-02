//Fazer um programa para ler o caminho de um arquivo .csv
//contendo os dados de itens vendidos. Cada item possui um
//nome, pre�o unit�rio e quantidade, separados por v�rgula. Voc�
//deve gerar um novo arquivo chamado "summary.csv", localizado
//em uma subpasta chamada "out" a partir da pasta original do
//arquivo de origem, contendo apenas o nome e o valor total para
//aquele item (pre�o unit�rio multiplicado pela quantidade).

package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;

public class FileEFileWriter {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

//		Criei o arquivo "itens.csv" na pasta do projeto com o seguinte conte�do:
//		TV LED,1290.99,1
//		Video Game Chair,350.50,3

		List<Produto> listaDeProdutos = new ArrayList<>();

		File itens = new File(".\\itens.csv");

//		� poss�vel abrir mais de um recurso no bloco try utilizando o ";":
		try (Scanner sc = new Scanner(itens); var bw = new BufferedWriter(new FileWriter(itens, true))) {
//			o argumento "true" do construtor do FileWriter indica que ir� adicionar ao arquivo j� existente, e n�o
//			sobrescrev�-lo! Sem esse argumento, escreveria por cima do arquivo existente.

//			Irei adicionar mais dois itens ao arquivo:
			bw.newLine();
			bw.write("Iphone X,900.00,2");
			bw.newLine();
			bw.write("Samsung Galaxy 9,850.00,2");

			while (sc.hasNextLine()) {
				Scanner linha = new Scanner(sc.nextLine());
//				linha.useLocale(Locale.US);
				linha.useDelimiter(",");
				String nome = linha.next();
				Double valor = linha.nextDouble();
				Integer quantidade = linha.nextInt();
				listaDeProdutos.add(new Produto(nome, valor, quantidade));
				linha.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

//		MANIPULANDO PASTAS COM O FILE:

//		--- Listando as pastas de um diret�rio:
//		File path = new File("."); // Diret�rio atual
//		File path = new File("c:\\Usu�rios"); // Nome completo de um diret�rio
		File pathSrc = new File(".\\src"); // Diret�rio "src" dentro do diret�rio atual
		File[] folders = pathSrc.listFiles(File::isDirectory);
		for (File folder : folders) {
			System.out.println(folder);
		}
//			output:
//				.\src\application
//				.\src\entities

//		--- Listando os arquivos de um diret�rio:
		File pathApplication = new File(".\\src\\application");
		File[] arquivos = pathApplication.listFiles(File::isFile);
		for (File arquivo : arquivos) {
			System.out.println(arquivo);
		}
//			output:
//				.\src\application\FileEFileWriter.java
//				.\src\application\FileEScanner.java
//				.\src\application\FileReaderEBufferedReader.java
//				.\src\application\InputStreamReaderBufferedReader.java
//				.\src\application\TryWithResources.java

//		--- Informa��es sobre o diret�rio do arquivo
		System.out.println(itens.getPath()); // output: itens.csv
		System.out.println(itens.getPath()); // output: .
		System.out.println(itens.getAbsolutePath()); // output:
														// D:\Documentos\Projetos\ws-curso-de-java\022arquivosETryWithResources\itens.csv

//		CRIANDO A NOVA PASTA E NOVO ARQUIVO ".csv" E ESCREVENDO NELE
		
		boolean success = new File(itens.getParent() + "\\out").mkdir(); // Cria nova pasta a partir da pasta de "itens.csv"
		System.out.println("A pasta foi criada? " + success); // output: true
		
		try (var bw2 = new BufferedWriter(new FileWriter(new File(".\\out\\summary.csv")))){
			for (Produto produto : listaDeProdutos) {
				bw2.write(produto.getNome() + "," + produto.getPrecoTotal());
				bw2
				.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//			output: foi criado o arquivo summary.csv, dentro da pasta out, com o seguinte conte�do:
//				TV LED,1290.99
//				Video Game Chair,1051.5
//				Iphone X,1800.0
//				Samsung Galaxy 9,1700.0
	
	}
}