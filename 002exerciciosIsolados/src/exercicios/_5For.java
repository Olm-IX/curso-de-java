package exercicios;

import java.util.Scanner;

public class _5For {
	
	public static void main(String[] args) {
		/*
		 * Leia um valor inteiro N. Este valor será a quantidade de valores inteiros X que serão lidos em seguida.
		 * Mostre quantos destes valores X estão dentro do intervalo [10,20] e quantos estão fora do intervalo, mostrando 
		 * essas informações conforme exemplo (use a palavra "in" para dentro do intervalo, e "out" para fora do intervalo).
		 *  
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o número de valores que serão lidos: ");
		int n = sc.nextInt();
		
		int num;
		int in = 0;
		int out = 0;
		
		for (int i = 1; i <= n; i++) {
			System.out.print("Digite o numero " +i+ " : ");
			num = sc.nextInt();
			if (num >= 10 && num <= 20) {
				in += 1;					
			} else {
				out += 1;			
			}	
		}
		
		System.out.println(in + " in");
		System.out.println(out + " out");

		sc.close();
	}
}
