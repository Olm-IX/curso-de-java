package exercicios;

import java.util.Scanner;

public class _2ExercicioIfElse {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite tres numeros inteiros para verificar o maior: ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		if (num1 > num2 && num1 > num3) { // && OPERADOR "E"
			System.out.println("Higher: " + num1);
		}else if (num2 > num3) {
			System.out.println("Higher: " + num2);
		}else {
			System.out.println("Higher: " + num3);
		}
		
		System.out.println("---------------------------------------");
		
		
		
		
		// OUTRO
		
		System.out.println("Digite dois numeros inteiros para verificar se sao multiplos: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if (a % b == 0 || b % a == 0) { // || OPERADOR "OU"
			System.out.println("SAO MULTIPLOS!");
		}else{
			System.out.println("NAO SAO MULTIPLOS!");
		}
		
		System.out.println("---------------------------------------");
		
		
		
		
		// OUTRO 
		
		System.out.println("Digite a hora inicial e final de um jogo para verificar o tempo de jogo: ");
		int in = sc.nextInt();
		int fin = sc.nextInt();
		int tempo;
		
		if (fin > in) {
			tempo = fin - in;
		} else {
			tempo = 24 - in + fin;	// Pode começar em um dia e terminar em outro		
		}
		System.out.println("O jogo durou " + tempo + " hora(s)");
		
		sc.close();
		
	}

}
