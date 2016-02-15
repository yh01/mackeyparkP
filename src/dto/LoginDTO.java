package dto;

public class LoginDTO {
	private String id;
	private String password;
	private String credit;

	public String getCredit() {
		return credit;
	}



	public void setCredit(String credit) {
		this.credit = credit;
	}



	public LoginDTO(){

	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
