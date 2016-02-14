package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.GoLoginDAO;

public class GoLoginAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	GoLoginDAO dao = new GoLoginDAO();


	public String execute(){
		if(session.containsKey("id")){
			System.out.println("成功");
			return "success";
		}
		System.out.println("失敗");
		return "error";
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
