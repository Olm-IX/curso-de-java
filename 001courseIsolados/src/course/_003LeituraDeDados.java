package course;

import java.util.Locale;
import java.util.Scanner;

public class _003LeituraDeDados {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner nome = new Scanner(System.in);
		// Apertar o "ctrl shift o" e importar a classe Scanner do java.util.Scanner. Irá criar um objeto de scanner chamado "nome"
		System.out.println("Leitura do texto ate a quebra de linha");
		String frase = nome.nextLine(); 
		
		System.out.println("Leitura de tres palavras, separadas por quebra de linha ou espaço");
		String x, y, z;
		x = nome.next(); // Para ler uma única palavra na mesma linha ou linhas separadas
		y = nome.next();
		z = nome.next();
		
		System.out.println("Leitura de um numero inteiro");
		int n1 = nome.nextInt();
		
		System.out.println("Leitura do genero em um caracter");
		char gender = nome.next().charAt(0); // PARA PEGAR APENAS O PRIMEIRO CARACTER e não o string todo.
		
		// Se eu vier aqui e colocar para ler um novo "nextLine()" não vai funcionar! Pq ele já considera a quebra de linha anterior!
		// Para contornar isso temos que por um nextLine vazio para "limpar" a quebra de linha que fica pendente na stream.
		// Se antes foi dada uma quebra de linha na stream de entrada sem o nextLine() temos que limpar a stream.
		// Essa limpeza de stream de entrada se chama FLUSH
		
		nome.nextLine(); // Limpeza de stream, flush
		System.out.println("Leitura de outro texto ate a quebra de linha");
		String outrafrase = nome.nextLine();
		
		System.out.println("Leitura do codigo b5, armazenando a letra em um atributo e o numero em outro");
		String coisa = nome.next();
		char letter = coisa.charAt(0); // vai gravar apenas o primeiro caracter da "coisa" no atributo "letter" 
		int digit = Integer.parseInt(coisa.substring(1)); // para converter a string num inteiro, vai "recortar" a string lida!
		
		System.out.println("Leitura de um numero fracionario, utilizando o ponto e nao a virgula");
		// Se eu colocar isso "Locale.setDefault(Locale.US);" aqui não vai adiantar nada! Tem que por antes do objeto Scanner.
		double n2 = nome.nextDouble();
		
		System.out.println("Digite 'Maria F 23 1.68' e guarde tudo em atributos separados ");
		String nome2 = nome.next();
		char gender2 = nome.next().charAt(0);
		int age = nome.nextInt();
		double height = nome.nextDouble();
		
		
		System.out.println(frase);
		// Abreviação: escrever sysout e apertar "ctrl espaço".
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(n1);
		System.out.println(gender);
		System.out.println(outrafrase);
		System.out.println(letter);
		System.out.println(digit);
		System.out.println(n2);
		System.out.println(nome2);
		System.out.println(gender2);
		System.out.println(age);
		System.out.println(height);
		
		nome.close(); // Não esquecer de fechar o objeto após o uso
				
	}
}
