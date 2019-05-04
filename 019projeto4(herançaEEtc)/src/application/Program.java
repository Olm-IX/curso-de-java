package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		List<Product> produtos = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int number = sc.nextInt();

		for (int i = 1; i <= number; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char tipo = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			switch (tipo) {
			case 'c':
				produtos.add(new Product(name, price));
				break;
			case 'u':
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date data = sdf.parse(sc.next());
				produtos.add(new UsedProduct(name, price, data));
				break;
			case 'i':
				System.out.print("Customs fee: ");
				Double fee = sc.nextDouble();
				produtos.add(new ImportedProduct(name, price, fee));
				break;
			}
		}

		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product item : produtos) {
			System.out.println(item.priceTag());
		}
		sc.close();
	}

}
