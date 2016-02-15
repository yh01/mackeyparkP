package action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.GoPurchaseDAO;
import util.DBconnector;
public class GoPurchaseAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	GoPurchaseDAO dao = new GoPurchaseDAO();
	public String execute(){
		String result = "error";
		if(session.containsKey("id") && session.containsKey("credit")){
			System.out.println("成功");
			dao.loginPopup2();
			result =  "success";
		}
		if(session.containsKey("id") && !session.containsKey("credit")){
			System.out.println("失敗");
			dao.loginPopup2();
			result =  "error";
		}
		return result;
	}


	private Connection con;
	private String sql;
	private String myid;
    private String mypass;
    private String credit;
	public boolean select(String id){
		boolean res = true;

		try{
			con = (Connection)DBconnector.getConnection();
			java.sql.Statement stm = con.createStatement();
			sql = "SELECT * FROM test WHERE id = '"+id+"'";
			ResultSet rs = stm.executeQuery(sql);

                while(rs.next()){
	                credit = rs.getString("credit");
                }
	            if(myid == null){
	            	res = false;
	            }

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return res;

	}
	public String getMyid(){return this.myid;}
	public String getPass(){return this.mypass;}
	public String getCredit(){return this.credit;}


	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

