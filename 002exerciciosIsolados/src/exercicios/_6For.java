package exercicios;

import java.util.Scanner;

public class _6For {
	
	/*
	 * Ler um valor N. Calcular e escrever seu respectivo fatorial. Fatorial de N = N * (N-1) * (N-2) * (N-3) * ... * 1.
	 * Lembrando que, por definição, fatorial de 0 é 1.
	 * 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		System.out.print("Digite um número para calcular o seu fatorial: ");
		int num = sc.nextInt();
		
		if (num == 0) {
			System.out.println("1");
		}else if (num < 0){
			System.out.println("Numero invalido");
		}else{
			int fat = 1;
			for (int i = num; i != 1; i--) {
				fat *= i;
			}
			System.out.println(fat);
		}
		sc.close();
		
	}

}
