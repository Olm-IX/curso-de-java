package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// SEM O CONSTRUTOR, JÁ TERIA INSTANCIADO AQUI
		
		System.out.println("Enter product data: ");
		System.out.print("Name: ");
		String name = sc.nextLine(); 
		
		// CRIAR VARIÁVEIS TEMPORÁRIAS ANTES DE INSTANCIAR O OBJETO
		
		System.out.print("Price: ");
		double price = sc.nextDouble();
		
		System.out.print("Quantity in stock: ");
		int quantity = sc.nextInt();
		System.out.println();
		
		Product product = new Product (name, price, quantity); 
		// AQUI VOCÊ ESTÁ OBRIGANDO A JÁ ATRIBUIR VALORES AOS ATRIBUTOS DO OBJETO JÁ NA INSTANCIAÇÃO!! ISSO É DEVIDO AO CONSTRUTOR
		// ISSO EVITA QUE SEJA FEITO ALGUM ERRO EM QUE SEJA CRIADO UM OBJETO COM OS ATRIBUTOS VAZIOS "NULL" "0" "0.0";
		
		System.out.println("Product data: " + product);
		System.out.println();
		System.out.print("Enter the number of products to be added in stock: ");
		quantity = sc.nextInt();
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