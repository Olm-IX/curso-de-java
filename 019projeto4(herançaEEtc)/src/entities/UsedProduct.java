package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class UsedProduct extends Product {
	
	private Date manufactureDate;
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " (used) $ ");
		sb.append(getPrice() + " (Manufacture date: ");
		sb.append(sdf.format(manufactureDate) + ")");
		return sb.toString();
	}
}
