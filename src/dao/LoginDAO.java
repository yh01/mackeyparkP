package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import dto.LoginDTO;
import util.DBconnector;

public class LoginDAO  extends ActionSupport{

	LoginDTO dto = new LoginDTO();

	public boolean searchDB (String mail_address, String password){

		boolean result = false;
		Connection con = DBconnector.getConnection("openconnect");	//DBに接続
		String sql = "SELECT * FROM user WHERE mail_address=? AND password=?";  //テーブル(user)から入力されたmail_adressとpasswordを検索

		try{
			PreparedStatement ps = con.prepareStatement(sql);		//DBにSQL文を送信する

			ps.setString(1, mail_address);		//取ってきたデータを1にmail_adressとしてセット
			ps.setString(2, password);			//取ってきたデータを2にpasswordとしてセット
			ResultSet rs = ps.executeQuery(); //結果を受け取る

			if(rs.next()){
				//結果を確認して登録があればトゥルー
				int user_id = rs.getInt("user_id");
				String  user_name= rs.getString("user_name"); //レコードの値
				String name_kana = rs.getString("name_kana");
				String credit_number = rs.getString("credit_number");
				String token = rs.getString("token");
				String unique_id = rs.getString("unique_id");

				dto.setUser_id(user_id);
				dto.setUser_name(user_name);
				dto.setName_kana(name_kana);
				dto.setCredit_number(credit_number);
				dto.setToken(token);
				dto.setUnique_id(unique_id);

				result = true;
			}
		}catch(SQLException e){			//それ以外はフォルス
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
		return result;
	}

	public LoginDTO getDto() {
		return dto;
	}
}