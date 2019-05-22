package course;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _12Excecoes {
	
	// PILHA DE CHAMADA DE MÉTODOS
	
	public static void main(String[] args) {
		method1();
		System.out.println("End of program");
	}

	public static void method1() {
		System.out.println("***METHOD1 START***");
		method2();
		System.out.println("***METHOD1 END***");
	}

	public static void method2() {
		System.out.println("***METHOD2 START***");
		Scanner sc = new Scanner(System.in);
		
		// EXCECOES
		// COLOCAR A PARTE EM QUE PODE OCORRER UM ERRO NO BLOCO "TRY"
		try {
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
		} catch (ArrayIndexOutOfBoundsException e) { // IRÁ CAPTURAR A EXCEÇÃO E EXECUTAR O BLOCO CATCH, CASO OCORRA!
			System.out.println("Invalid position!");
			e.printStackTrace(); // ISSO É PARA APARECER A MENSAGEM DO ERRO NA TELA
			sc.next();
		} catch (InputMismatchException e) {
			System.out.println("Input error");
		}
		sc.close();
		System.out.println("***METHOD2 END***");
	}
}