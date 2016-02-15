package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dto.CreditCheckDTO;
import util.DBconnector;

/**
 * クレジット情報をデータベースから取得するためのクラス
 * @author K.sugano
 * @version 1.0
 * @since 1.0
 */
public class CreditCheckDAO {

	/**
	 * 結果
	 */
	boolean result;

	/**
	 * プリペアードステートメント
	 */
	PreparedStatement ps=null;

	/**
	 * コネクション
	 */
	private Connection con;

	/**
	 * ユーザーIDからクレジット情報を取得し格納するためのメソッド
	 * @param userId ユーザーID
	 * @param creditDTO クレジット情報格納DTO
	 * @return result クレジット情報が正しく取得出来たか否か
	 */
	public boolean select(int userId,CreditCheckDTO creditDTO){
		result=false;
		con=(Connection)DBconnector.getConnection();
		String sql="SELECT card_num, token FROM user WHERE id = ? ";
		try{
			ps=(PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs =ps.executeQuery();
			if  (rs.next()) {
				creditDTO.setCreditNum(rs.getInt("card_num"));
				creditDTO.setCreditToken(rs.getString("token"));
				result=true;
			}
			}catch (SQLException e) {
			e.printStackTrace();
			}finally{
				try{
					con.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			return result;
	}
}