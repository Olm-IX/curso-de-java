package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		sc.nextLine();
		String status = sc.nextLine();
		Order order = new Order(
				new Client(name, email, birthDate), 
				OrderStatus.valueOf(status), 
				new Date());
		
		System.out.print("How many items to this order? ");
		int quantidadeItems = sc.nextInt();
		for (int i = 1; i<=quantidadeItems; i++) {
			System.out.println("Enter  order #" + i + " data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			order.addOrderItem(new OrderItem(
					new Product(productName, productPrice), 
					productQuantity));
		}
		System.out.println();
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order);
		
		sc.close();
	}

}
