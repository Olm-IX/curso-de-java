package entities;

public class OrderItem {
	private Product product;
	private int quantity;

	public OrderItem (Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Double subTotal () {
		return product.getPrice() * quantity;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(product.getName() + ", ");
		sb.append("$" + product.getPrice() + ", ");
		sb.append("Quantity: " + quantity + ", ");
		sb.append("Subtotal: $" + subTotal());
		return sb.toString();
	}

}


