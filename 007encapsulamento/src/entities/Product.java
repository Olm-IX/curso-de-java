package entities;

public class Product {
	
	// MUDAR OS ATRIBUTOS PARA PRIVATE. COMO REGRA, O PROGRAMA PRINCIPAL N�O PODE ACESSAR NENHUM ATRIBUTO DIRETAMENTE!
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
	
	// GETTERS AND SETTERS - POR CONVEN��O, S�O COLOCADOS AP�S OS CONSTRUTORES
	// O NOME COME�A COM get OU set SEGUIDO DO NOME DO ATRIBUTO EM CAMEL CASE
	// O GET � DO TIPO DO ATRIBUTO, E O SET � VOID 
	// DA PARA GERAR AUTOMATICAMENTE Bot�o direito -> Source -> Generate Getters and Setters
	
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
	// A QUANTIDADE DO PRODUTO S� PODER� SER ALTERADA PELOS M�TODOS DE ENTRADA OU SA�DE DE PRODUTOS. ASSIM, N�O CRIAREMOS UM M�TODO setQuantity!!!
	//  ISSO SERIA UMA REGRA DE NEG�CIO PARA PROTEGER A INTEGRIDADE DOS DADOS DA QUANTIDADE DO PRODUTO!
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
	// toString � UM M�TODO DA CLASSE OBJECT, QUE � A SUPERCLASSE DE TODAS
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