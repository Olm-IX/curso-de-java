package exercicios;

import java.util.Locale;
import java.util.Scanner;

public class _1ExpoenteMathPow {

	// Fa�a um programa para ler o valor do raio de um c�rculo, e depois mostrar o valor da �rea deste c�rculo com quatro casas decimais
	// F�rmula da �rea: area=pi.raio�
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		double pi = 3.14159;
		
		System.out.printf("Digite o raio do circulo: ");
		double raio = sc.nextDouble();
		double area = pi*Math.pow(raio, 2); // PARA ELEVAR UM NUMERO AO EXPOENTE "Math.pow(base, expoente)"
		
		System.out.printf("A= %.4f %n", area);
		
		sc.close();
		
	}

}
