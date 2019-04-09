package entities;

public class Product {
	public String name;
	public double price;
	public int quantity;


	public Product () {
		// SE QUISER SE MANTER O CONSTRUTOR PADR�O, ESCREVER ISSO! ASSIM DAR� PARA INSTANCIAR UM OBJETO VAZIO EX.: Product p = new Product ();
	}
	
	
	// CONSTRUTOR PERSONALIZADO
	public Product(String name, double price, int quantity) {
		this.name = name; 
		this.price = price;
		this.quantity = quantity;
		
	}
	
	// OUTRO CONSTRUTOR PERSONALIZADO, SOBRECARGA!!! COM ISSO DAR� PARA INICIALIZAR UM NOVO PRODUTO QUE N�O H� NO ESTOQUE
	public Product (String name, double price) {
		this.name = name;
		this.price = price;
		quantity = 0; // N�O PRECISA POR O THIS AQUI POIS N�O H� MAIS O PAR�METRO DO M�TODO. 
		// ISSO � OPCIONAL, POIS A VARI�VEL NO JAVA J� � INICIALIZADA COM O VALOR 0	
	}
	
	// AGORA QUE H� SOBRECARGA NOS CONSTRUTORES, D� PARA CHAMAR OU UM OU OUTRO, DEPENDENDO DO ARGUMENTO QUE VOC� INSERIR NO M�TODO! 
	
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