package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import dao.MContactDisplayDAO;
import dto.MContactDisplayDTO;

public class MContactDisplayAction extends ActionSupport{
	boolean result = true;
	private String contact_id;
	private String contact_name;
	private String contact;
	private ArrayList<MContactDisplayDTO> contactList;

	public String execute(){
		MContactDisplayDTO dto = new MContactDisplayDTO();
		MContactDisplayDAO dao = new MContactDisplayDAO();

		contactList = dao.selectM();
		if(!result){
			return ERROR;
		}

		contact_name = dto.getContact_name();

		return SUCCESS;
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

	public ArrayList<MContactDisplayDTO> getContactList() {
		return contactList;
	}

	public void setContactList(ArrayList<MContactDisplayDTO> contactList) {
		this.contactList = contactList;
	}
}
