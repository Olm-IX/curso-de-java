package entities;

public class Product {
	public String name;
	public double price;
	public int quantity;

	// O CONSTRUTOR GERALMENTE VEM APÓS OS ATRIBUTOS
	
	public Product(String name, double price, int quantity) {
		/* 
		 *  ISSO É O CONSTRUTOR
		 *  ATRIBUI OS PARAMETROS DO MÉTODO AOS ATRIBUTOS DA CLASSE
		 *  ASSIM NÃO SERÃO INICIALIZADOS VAZIOS!
		 *  DÁ PARA GERAR AUTOMATICAMENTE • Botão direito -> Source -> Generate Constructor using Fields
		 */

		this.name = name; // THIS SIGNIFICA QUE É O ATRIBUTO DA CLASSE, QUE TÁ LÁ EM CIMA. SEM O THIS SIGNIFICA QUE É O PARAMETRO DO METODO!
		this.price = price; // A PALAVRA THIS SERVE PARA DIFERENCIAR O ATRIBUTO DO OBJETO DO PARÂMETRO DO MÉTODO!
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