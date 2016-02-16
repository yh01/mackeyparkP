package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import dto.LoginOauthDTO;
import util.DBconnector;

/**
 * Oauthでログインに必要な情報を取得する為のクラス
 * @author 堅田 一成
 * @since 1.0
 * @version 1.0
 */
public class LoginOauthDAO{

	/**
	 * 取得した情報を格納する為のDTO
	 */
	private LoginOauthDTO dto=new LoginOauthDTO(); //LoginOauthDTOをインスタンス化
	/**
	 * 取得したユニークIDを照合するためのメソッド
	 * @param userUniqueId OAuthのサービス先のユニークID
	 * @param oauthName OAuthのサービス名
	 * @return result
	 */
	public boolean select(String userUniqueId, String oauthName){
		Connection con = null;
		boolean result = false;
		con = DBconnector.getConnection("openconnect");
		try{
			String sql = "SELECT * FROM user WHERE unique_id = ? AND oauth_name = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,userUniqueId);
			stmt.setString(2,oauthName);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				String credit_number = rs.getString("credit_number");
				String token = rs.getString("token");
				dto.setUserId(rs.getInt(1));
				dto.setUserName(rs.getString(2));
				dto.setCredit_number(credit_number);
				dto.setToken(token);
				result = true;
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * ユニークIDが無かったら作成
	 * @param uniqueId OAuthのサービス先のユニークID
	 * @param userName OAuthのサービス先のユーザー名
	 * @param oauthName OAuthのサービス名
	 * @param oauthName OAuthのemail
	 * @return result 結果
	 */

	//	public boolean insert(String uniqueId, String userName, String oauthName, String email) {
	//		Connection con = null;
	//		boolean result = false;
	//		Calendar cal = Calendar.getInstance();
	//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	//		String now = sdf.format(cal.getTime());
	//		con = DBConnector.getConnection();
	//		String sql = "INSERT INTO user(email, user_name, unique_id, oauth_name, registration_date, update_date) values (?,?,?,?,?,?)";
	//		try {
	//			PreparedStatement stmt = con.prepareStatement(sql);
	//			stmt.setString(1, email);
	//			stmt.setString(2, userName);
	//			stmt.setString(3, uniqueId);
	//			stmt.setString(4, oauthName);
	//			stmt.setString(5, now);
	//			stmt.setString(6, now);
	//
	//			int insertCount = stmt.executeUpdate();
	//			if (insertCount > 0) {
	//				result = true;
	//			}
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		} finally {
	//			try {
	//				con.close();
	//			} catch (SQLException e) {
	//				e.printStackTrace();
	//			}
	//		}
	//		return result;
	//	}
	/**
	 * ユニークIDが無かったら作成
	 * @param uniqueId OAuthのサービス先のユニークID
	 * @param userName OAuthのサービス先のユーザー名
	 * @param oauthName OAuthのサービス名
	 * @return result 結果
	 */

	public boolean insert(String uniqueId, String userName, String oauthName) {
		Connection con = null;
		boolean result = false;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String now = sdf.format(cal.getTime());
		con = DBconnector.getConnection("openconnect");
		String sql = "INSERT INTO user(user_name, unique_id, oauth_name, user_registration_date) values (?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, userName);
			stmt.setString(2, uniqueId);
			stmt.setString(3, oauthName);
			stmt.setString(4, now);


			int insertCount = stmt.executeUpdate();
			if (insertCount > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * DTO取得メソッド
	 * @return dto
	 */
	public LoginOauthDTO getLoginOauthDTO() {
		return dto;
	}

	/**
	 * DTO格納メソッド
	 * @param dto ログインユーザDTO
	 */
	public void setLoginOauthDTO(LoginOauthDTO dto) {
		this.dto = dto;
	}
}