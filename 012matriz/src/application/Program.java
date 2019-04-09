package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] mat = new int[n][n]; // INSTANCIA��O DA MATRIZ
		
		for (int i=0; i<mat.length; i++) { // QUANTIDADE DE LINHAS � mat.lenght
			for (int j=0; j<mat[i].length; j++) { // A MATRIZ NA VERDADE � UM VETOR DE VETORES, ENT�O � S� TRATAR ELA COMO UM VETOR EM CADA LINHA E CHAMAR O LENGHT DO VETOR! 
				// VAI MOSTRAR A QUANTIDADE DE ELEMENTOS DE CADA LINHA, QUE � O N�MERO DE COLUNAS!
				mat[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Main diagonal:");
		for (int i=0; i<mat.length; i++) {
			System.out.print(mat[i][i] + " ");
		}
		System.out.println();
		
		int count = 0;
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat[i].length; j++) {
				if (mat[i][j] < 0) {
					count++;
				}
			}
		}
		System.out.println("Negative numbers = " + count);
		
		
		sc.close();
	}
}