package course;

import java.util.Locale;
import java.util.Scanner;

public class _007ExpressaoCondTernaria {

	public static void main(String[] args) {
		
		// EXPRESSÃO CONDICIONAL TERNÁRIA
		// Estrutura opcional ao if-else quando se deseja decidir um VALOR com base em uma condição
		// Sintaxe: ( condição ) ? valor_se_verdadeiro : valor_se_falso

		// Ex: se o preço for maior que 20, desconto de 10%. senão, desconto de 5%.
		
		Locale.setDefault(Locale.US); 
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite o preco");
		double preco = sc.nextDouble();
		
		double desconto = (preco > 20) ? preco * 0.1 : preco * 0.05;  // FICOU BEM MAIS SIMPLES QUE O IF ELSE!
		
		System.out.println("O desconto é: " + desconto);
		
		sc.close();
	}

}
