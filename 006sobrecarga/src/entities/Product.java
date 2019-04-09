package entities;

public class Product {
	public String name;
	public double price;
	public int quantity;


	public Product () {
		// SE QUISER SE MANTER O CONSTRUTOR PADRÃO, ESCREVER ISSO! ASSIM DARÁ PARA INSTANCIAR UM OBJETO VAZIO EX.: Product p = new Product ();
	}
	
	
	// CONSTRUTOR PERSONALIZADO
	public Product(String name, double price, int quantity) {
		this.name = name; 
		this.price = price;
		this.quantity = quantity;
		
	}
	
	// OUTRO CONSTRUTOR PERSONALIZADO, SOBRECARGA!!! COM ISSO DARÁ PARA INICIALIZAR UM NOVO PRODUTO QUE NÃO HÁ NO ESTOQUE
	public Product (String name, double price) {
		this.name = name;
		this.price = price;
		quantity = 0; // NÃO PRECISA POR O THIS AQUI POIS NÃO HÁ MAIS O PARÂMETRO DO MÉTODO. 
		// ISSO É OPCIONAL, POIS A VARIÁVEL NO JAVA JÁ É INICIALIZADA COM O VALOR 0	
	}
	
	// AGORA QUE HÁ SOBRECARGA NOS CONSTRUTORES, DÁ PARA CHAMAR OU UM OU OUTRO, DEPENDENDO DO ARGUMENTO QUE VOCÊ INSERIR NO MÉTODO! 
	
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