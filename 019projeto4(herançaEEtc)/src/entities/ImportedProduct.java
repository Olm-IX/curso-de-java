package entities;

public final class ImportedProduct extends Product {
	
	private Double customsFee;

	public ImportedProduct() {
		super();
	}
	
	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public Double totalPrice() {
		return getPrice() + customsFee;
	}
	
	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " $ ");
		sb.append(totalPrice() + " (Customs fee: $ ");
		sb.append(customsFee + ")");
		return sb.toString();
	}
	
	
	
	
}
