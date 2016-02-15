package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.GoPurchaseDAO;
public class GoPurchaseAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	GoPurchaseDAO dao = new GoPurchaseDAO();
	public String execute(){
		String result = "error";
		if(session.containsKey("id") && session.containsKey("credit")){
			System.out.println("成功");
			result =  "success";
		}
		if(session.containsKey("id") && !session.containsKey("credit")){
			System.out.println("失敗");
			result =  "error";
		}
		return result;
	}


	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

