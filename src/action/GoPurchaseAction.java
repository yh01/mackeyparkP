package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.GoPurchasePopDAO;
public class GoPurchaseAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	GoPurchasePopDAO dao = new GoPurchasePopDAO();
	public String execute(){
		String result = "success";
		if(!session.containsKey("user_id") && !session.containsKey("loginId")){
			System.out.println("user_id受け取れてない");
			dao.loginPopup1();
			result = ERROR;
		}

		if(session.containsKey("user_id") && !session.containsKey("credit_number")){
			dao.loginPopup4();
			result = "creditError";
		}
		if(session.containsKey("loginId") && !session.containsKey("credit_number")){
			dao.loginPopup4();
			result = "creditError";
		}


		if(session.containsKey("user_id") && session.containsKey("credit_number") || session.containsKey("token")){
			dao.loginPopup2();
			System.out.println("成功");
			result = SUCCESS;
		}
		if(session.containsKey("loginId") && session.containsKey("credit_number") || session.containsKey("token")){
			dao.loginPopup2();
			System.out.println("成功");
			result = SUCCESS;
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

