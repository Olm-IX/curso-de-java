package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Quartos;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		Quartos[] vetor = new Quartos[10]; // CRIA UM VETOR QUE APONTA PARA 10 OBJETOS DO TIPO QUARTOS (CLASSE).
		// VALORES INICIAIS S�O NULOS.
		// ISSO N�O � INSTANCIA��O, APENAS A CRIA��O DO VETOR DO TIPO QUARTOS!
		// CONSIDERAR QUE � UM HOTEL COM 10 QUARTOS VAZIOS. NUMERO 0 A 9.

		System.out.print("How many rooms will be rented? ");
		int quantidadeQuartosAlugados = sc.nextInt();

		String nome;
		String email;
		int numeroQuarto;

		for (int i = 0; i < quantidadeQuartosAlugados; i++) {
			System.out.printf("%nRent #%d:%nName: ", (i + 1));
			sc.nextLine(); // LIMPEZA DE STREAM (FLUSH)
			nome = sc.nextLine();
			System.out.print("Email: ");
			email = sc.nextLine();
			System.out.print("Room: ");
			numeroQuarto = sc.nextInt();
			vetor[numeroQuarto] = new Quartos(nome, email); // INSTANCIA��O (NEW)
		}

		System.out.printf("%nBusy Rooms:%n");
		for (int i = 0; i < vetor.length; i++) { // NOMEDOVETOR.LENGHT -> RETORNA O N�MERO DE ELEMENTOS DO VETOR!
			if (vetor[i] != null) {
				System.out.println(i + ": " + vetor[i].getNome() + ", " + vetor[i].getEmail());
			}
		}

		sc.close();
	}
}
