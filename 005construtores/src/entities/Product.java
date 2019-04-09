package entities;

public class Product {
	public String name;
	public double price;
	public int quantity;

	// O CONSTRUTOR GERALMENTE VEM AP�S OS ATRIBUTOS
	
	public Product(String name, double price, int quantity) {
		/* 
		 *  ISSO � O CONSTRUTOR
		 *  ATRIBUI OS PARAMETROS DO M�TODO AOS ATRIBUTOS DA CLASSE
		 *  ASSIM N�O SER�O INICIALIZADOS VAZIOS!
		 *  D� PARA GERAR AUTOMATICAMENTE � Bot�o direito -> Source -> Generate Constructor using Fields
		 */

		this.name = name; // THIS SIGNIFICA QUE � O ATRIBUTO DA CLASSE, QUE T� L� EM CIMA. SEM O THIS SIGNIFICA QUE � O PARAMETRO DO METODO!
		this.price = price; // A PALAVRA THIS SERVE PARA DIFERENCIAR O ATRIBUTO DO OBJETO DO PAR�METRO DO M�TODO!
		this.quantity = quantity;
		
	}
	
	public double totalValueInStock() {
		return price * quantity;
	}

	public void addProducts(int quantity) {
		this.quantity += quantity;
	}

	public void removeProducts(int quantity) {
		this.quantity -= quantity;
	}

	public String toString() {
		return name 
				+ ", $ " 
				+ String.format("%.2f", price) 
				+ ", " 
				+ quantity 
				+ " units, Total: $ "
				+ String.format("%.2f", totalValueInStock());
	}
}