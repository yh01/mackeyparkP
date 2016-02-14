package dto;

public class MDeleteDTO {
	private String Mongodelete;
	private String id;
	private String name;
	private float price;
	private String quantity;

	public String getMongodelete() {
		return Mongodelete;
	}

	public void setMongodelete(String mongodelete) {
		Mongodelete = mongodelete;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
