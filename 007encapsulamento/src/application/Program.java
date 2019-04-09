package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter product data: ");
		System.out.print("Name: ");
		String name = sc.nextLine(); 
		
		System.out.print("Price: ");
		double price = sc.nextDouble();

		System.out.println();
		
		Product product = new Product (name, price);
		
		// SUPONDO QUE QUEIRAMOS MUDAR O NOME DO PRODUTO.
		// SE EU ESCREVER / product.name = "Computer" / VAI DAR ERRO, POIS AGORA O ATRIBUTO name ESTÁ PRIVADO!
		// USAR O SETTER
		product.setName("Computer");
		product.setPrice(1200.00);
		// PARA IMPRIMIR APENAS O NOME DO PRODUTO, SE EU COLOCAR System.out.println(product.name) VAI DAR ERRO, POIS NÃO POSSO ACESSAR O ATRIBUTO DIRETAMENTE!
		// USAR O GETTER
		System.out.println("Updated name: " + product.getName());
		System.out.println("Updated price: " + product.getPrice());
		
		System.out.println();
		System.out.println("Product data: " + product);
		System.out.println();
		System.out.print("Enter the number of products to be added in stock: ");
		int quantity = sc.nextInt();
		product.addProducts(quantity);
		System.out.println();
		System.out.println("Updated data: " + product);
		System.out.println();
		System.out.print("Enter the number of products to be removed from stock: ");
		quantity = sc.nextInt();
		product.removeProducts(quantity);
		System.out.println();
		System.out.println("Updated data: " + product);
		
		sc.close();
	}
}