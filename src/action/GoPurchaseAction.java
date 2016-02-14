package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.GoPurchaseDAO;
public class GoPurchaseAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	GoPurchaseDAO dao = new GoPurchaseDAO();
	public String execute(){
		if(session.containsKey("id")){
			System.out.println("成功");
			return "success";
		}else if(session.containsKey("loginId")){
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

