package entities;

public class Product {
	
	private String name;
	private Double price; 
	private Integer quantity;
	
	public Product() {
	}

	public Product(String productName, Double price, Integer quantity) {
		this.name = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String productName) {
		this.name = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public double finalPrice () {
		return quantity * price;
	}
	
	@Override
	
	public String toString() {
		return name 
				+ ", "
				+ finalPrice();
	}
	
}
