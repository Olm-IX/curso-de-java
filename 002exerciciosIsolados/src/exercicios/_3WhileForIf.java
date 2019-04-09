package exercicios;

import java.util.Scanner;

public class _3WhileForIf {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite um numero: ");
		int num = sc.nextInt();
		
		while (num<=0) {
			System.out.print("O numero tem que ser positivo! Digite novamente: ");
			num = sc.nextInt();
		}	
		

		int value;
		int maxvalue = Integer.MIN_VALUE; // Menor valor possível para um integer! Tem também o maior valor, que é "Integer.MAX_VALUE"
		
		for (int i = 1; i <= num; i++) {
			System.out.print("Value #" +i+ ": ");
			value = sc.nextInt();
			if (value > maxvalue) {
				maxvalue = value;
			}
		}
		
		System.out.println("Higher = "+maxvalue);
		
		
		sc.close();
	}

}
