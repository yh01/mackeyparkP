package action;
import com.opensymphony.xwork2.ActionSupport;

import dao.MUpdateDAO;

public class MUpdateAction extends ActionSupport{
	private String id;
	private String name;
	private double price;
	private String quantity;

	public String execute() {
		MUpdateDAO dao = new MUpdateDAO();
		System.out.println("ＤＡＯに入っていれば0＝"+dao.update(id, name, price, quantity));


		System.out.println("IDは"+id);
		System.out.println("nameは"+name);
		System.out.println("priceは"+price);
		System.out.println("quantityは"+quantity);


		return SUCCESS;
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
