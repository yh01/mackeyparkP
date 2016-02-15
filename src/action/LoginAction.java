package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.LoginDAO;
import dto.LoginDTO;

public class LoginAction extends ActionSupport implements SessionAware{

	public String id;

	public String password;

	public String credit;

	private Map<String,Object>session;

	public String execute(){

		LoginDAO dao = new LoginDAO(); //LoginDAOクラスを作成すると波線が消える

		boolean res = dao.select(id,password);

		if(!res){
			return ERROR;
		}

		 LoginDTO dto = new LoginDTO();
		 dto = dao.getDto();

		 System.out.println(dto.getCredit());

		session.put("id", id );
		session.put("password", password );
		session.put("credit",dto.getCredit());


		return SUCCESS;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getPass(){
		return password;
	}

	public void setPass(String password){
		this.password = password;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}
	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}


}