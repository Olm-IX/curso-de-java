package application;

import java.util.Locale;
import java.util.Scanner;

import util.CurrencyConverter;



public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("What is the dollar price? ");
		Double dollarPrice = sc.nextDouble();
		System.out.print("How many dollars will be bought? ");
		Double amount = sc.nextDouble();
		
		System.out.printf("Amount to be paid in reais = R$ %.2f ", CurrencyConverter.converter(dollarPrice, amount)); // NÃO HÁ INSTANCIAÇÃO, CHAMA PELO NOME DA CLASSE!
		
	
		sc.close();
	}

}
