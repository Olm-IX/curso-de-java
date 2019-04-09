package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		System.out.print("Numero de linhas: ");
		int linhas = sc.nextInt();
		System.out.print("Numero de colunas: ");
		int colunas = sc.nextInt();

		double[][] mat = new double[linhas][colunas];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
			mat[i][j] = sc.nextDouble();
			}
		}
		System.out.println();
		System.out.print("Valor para verificação: ");
		double valor = sc.nextDouble();

		int contador = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == valor) {
					contador++;
					System.out.println("Position: " + i + "," + j);
					if (j - 1 >= 0) {
						System.out.println("Left: " + mat[i][j - 1]);
					}
					if (j + 1 < mat[i].length ) {
						System.out.println("Right: " + mat[i][j + 1]);
					}
					if (i - 1 >= 0 ) {
						System.out.println("Up: " + mat[i - 1][j]);
					}
					if (i + 1 < mat.length) {
						System.out.println("Down: " + mat[i + 1][j]);
					}
				}
			}
		}

		System.out.println();
		System.out.println("Numero de ocorrencias: " + contador);
		sc.close();
	}

}
