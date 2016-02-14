package action;


import com.opensymphony.xwork2.ActionSupport;

import dao.MInsertDAO;
import dto.MInsertDTO;

public class MInsertAction extends ActionSupport{
	private String id;
	private String name;
	private float price;
	private String quantity;



	public String execute(){


		MInsertDAO dao = new MInsertDAO();
		MInsertDTO dto = new MInsertDTO();

		boolean result = dao.insert(dto,id,name,price,quantity);
		  if(!result){
	        	return ERROR;
	       }
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
