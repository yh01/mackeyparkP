package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MainTicketListDTO;
import util.DBconnector;

/**
 * @author 星野
 *
 */
public class MainTicketListDAO {

	/**
	 * チケット一覧情報を格納するリスト
	 */
	private ArrayList<MainTicketListDTO> selectList = new ArrayList<>();

	/**
	 * MySQLのデータを取得する為のメソッド
	 * @return result 取得できたらリストに格納してtrue、できなかったらfalseを返します。
	 */
	public boolean selectMySQL() {
		boolean result = false;

		Connection connection = DBconnector.getConnection("park");
		String sql = "select*from ticket group by division order by item_id";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MainTicketListDTO dto = new MainTicketListDTO();
				dto.setDivision(rs.getString("division"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setPrice(rs.getInt("price"));
				selectList.add(dto);
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * チケット一覧のリストを取得する為のメソッド
	 * @return selectList チケット一覧
	 */
	public ArrayList<MainTicketListDTO> getSelectList() {
		return selectList;
	}

	/**
	 * チケット一覧のリストを格納する為のメソッド
	 * @param selectList チケット一覧
	 */
	public void setSelectList(ArrayList<MainTicketListDTO> selectList) {
		this.selectList = selectList;
	}
}
