package entities;

public class Product {
	
	// MUDAR OS ATRIBUTOS PARA PRIVATE. COMO REGRA, O PROGRAMA PRINCIPAL NÃO PODE ACESSAR NENHUM ATRIBUTO DIRETAMENTE!
	private String name;
	private double price;
	private int quantity;

	
	
	// CONSTRUTORES
	public Product () {	}	
	public Product(String name, double price, int quantity) {
		this.name = name; 
		this.price = price;
		this.quantity = quantity;
	}
	public Product (String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	// GETTERS AND SETTERS - POR CONVENÇÃO, SÃO COLOCADOS APÓS OS CONSTRUTORES
	// O NOME COMEÇA COM get OU set SEGUIDO DO NOME DO ATRIBUTO EM CAMEL CASE
	// O GET É DO TIPO DO ATRIBUTO, E O SET É VOID 
	// DA PARA GERAR AUTOMATICAMENTE Botão direito -> Source -> Generate Getters and Setters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	// A QUANTIDADE DO PRODUTO SÓ PODERÁ SER ALTERADA PELOS MÉTODOS DE ENTRADA OU SAÍDE DE PRODUTOS. ASSIM, NÃO CRIAREMOS UM MÉTODO setQuantity!!!
	//  ISSO SERIA UMA REGRA DE NEGÓCIO PARA PROTEGER A INTEGRIDADE DOS DADOS DA QUANTIDADE DO PRODUTO!
	public int getQuantity() {
		return quantity;
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

	@Override 
	// toString É UM MÉTODO DA CLASSE OBJECT, QUE É A SUPERCLASSE DE TODAS
	// AS CLASSES DO JAVA! POR ISSO O OVERRIDE
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