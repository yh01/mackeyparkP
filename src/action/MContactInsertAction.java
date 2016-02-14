package action;

import dao.MContactInsertDAO;
import dto.MContactInsertDTO;

public class MContactInsertAction {
	private String contact_id;
	private String contact_name;
	private String contact;

	public String execute(){


		MContactInsertDAO dao = new MContactInsertDAO();
		MContactInsertDTO dto = new MContactInsertDTO();

		boolean result = dao.insert(dto,contact_id,contact_name,contact);
			if(!result){
			  return "error";
			}
	        return "success";

		}


	public String getContact_id() {
		return contact_id;
	}
	public void setContact_id(String contact_id) {
		this.contact_id = contact_id;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}
