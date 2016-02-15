package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import dto.LoginDTO;
import util.DBconnector;

public class LoginDAO extends ActionSupport{
	private boolean res;
	private Connection con;
	private String sql;
	private PreparedStatement ps;
	private ResultSet rs;

	LoginDTO dto = new LoginDTO();

	public boolean select(String id, String password){ //DAOのselectの戻りはboolean
		res = false;
		try{
			con = (Connection)DBconnector.getConnection();
			sql = "SELECT * FROM test WHERE";  //login_tableがテーブル名
			sql+= " id = ? AND password = ? ";

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs = ps.executeQuery(); //更新した件数、アップデートした件数

			if(rs.next()){
				String credit = rs.getString("credit");
				dto.setCredit(credit);
				res = true;
			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


		return res;
	}


	public LoginDTO getDto() {
		return dto;
	}

	public void setDto(LoginDTO dto) {
		this.dto = dto;
	}
}