package dto;

import java.util.ArrayList;

public class MContactDisplayDTO {
	private String contact_id;
	private String contact_name;
	private String contact;
	private ArrayList<MContactDisplayDTO> contactList;
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
