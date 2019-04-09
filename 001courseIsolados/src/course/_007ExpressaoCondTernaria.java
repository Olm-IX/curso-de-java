package course;

import java.util.Locale;
import java.util.Scanner;

public class _007ExpressaoCondTernaria {

	public static void main(String[] args) {
		
		// EXPRESS�O CONDICIONAL TERN�RIA
		// Estrutura opcional ao if-else quando se deseja decidir um VALOR com base em uma condi��o
		// Sintaxe: ( condi��o ) ? valor_se_verdadeiro : valor_se_falso

		// Ex: se o pre�o for maior que 20, desconto de 10%. sen�o, desconto de 5%.
		
		Locale.setDefault(Locale.US); 
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite o preco");
		double preco = sc.nextDouble();
		
		double desconto = (preco > 20) ? preco * 0.1 : preco * 0.05;  // FICOU BEM MAIS SIMPLES QUE O IF ELSE!
		
		System.out.println("O desconto �: " + desconto);
		
		sc.close();
	}

}
