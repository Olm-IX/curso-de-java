package exercicios;

import java.util.Scanner;

public class _4While {

	public static void main(String[] args) {

		/* Um Posto de combustíveis deseja determinar qual de seus produtos tem a preferência de seus clientes. Escreva 
		 * um algoritmo para ler o tipo de combustível abastecido (codificado da seguinte forma: 1.Álcool 2.Gasolina 3.Diesel
		 * 4.Fim). Caso o usuário informe um código inválido (fora da faixa de 1 a 4) deve ser solicitado um novo código (até
		 * que seja válido). O programa será encerrado quando o código informado for o número 4. Deve ser escrito a
		 * mensagem: "MUITO OBRIGADO" e a quantidade de clientes que abasteceram cada tipo de combustível, conforme
		 * exemplo. 
		 */

	Scanner sc = new Scanner(System.in);
		
	int x = 0;
	int gasolina = 0;
	int alcool = 0;
	int diesel = 0;
	
	while (x != 4) {
		
		System.out.printf("Digite que combustível foi abastecido:%n 1 - Alcool%n 2 - Gasolina%n 3 - Diesel%n 4 - Sair %n");
		System.out.println("------------");
		x = sc.nextInt();
		
		switch (x) {
			case 1:
				alcool = alcool + 1;
				System.out.println("Alcool");
				System.out.printf("------------ %n");
				break;
			case 2:
				gasolina = gasolina + 1;
				System.out.println("Gasolina");
				System.out.printf("------------ %n");
				break;
			case 3:
				diesel = diesel + 1;
				System.out.println("Diesel");
				System.out.printf("------------ %n");
				break;
			case 4:
				System.out.println("Fim");
				System.out.printf("------------ %n");
				break;
			default: 
				System.out.println("Código inválido, digite novamente");
				System.out.printf("------------ %n");
		}
	}
	System.out.println("MUITO OBRIGADO!");
	System.out.println("Alcool: " + alcool);
	System.out.println("Gasolina: " + gasolina);
	System.out.println("Diesel: " + diesel);
	
	sc.close();
	
	}
}

