package action;

import java.util.ArrayList;

import dao.MainTicketListDAO;
import dto.MainTicketListDTO;

/**
 * @author 星野
 *メイン画面でチケットの値段一覧を表示するためのアクションクラス
 */
public class MainTicketListAction {
	/**
	 * チケット一覧のリスト
	 */
	private ArrayList<MainTicketListDTO> selectList = new ArrayList<>();

	/**
	 * MySQLのデータを取得する為のメソッド
	 * @return result データを取得できたら、リストに格納をしてSUCCESS、できなかったらERRORを返します。
	 */
	public String execute(){
		System.out.println("aaa");
		String result = "error";
		MainTicketListDAO dao = new MainTicketListDAO();
		if(dao.selectMySQL()){
			selectList = dao.getSelectList();
			result = "success";
		}
		System.out.println("aaa");
		return result;
	}

	/**
	 * チケット一覧のリストを取得する為のメソッド
	 * @return selectList チケット一覧のリスト
	 */
	public ArrayList<MainTicketListDTO> getSelectList() {
		return selectList;
	}

	/**
	 * チケット一覧のリストを格納する為のメソッド
	 * @param selectList チケット一覧のリスト
	 */
	public void setSelectList(ArrayList<MainTicketListDTO> selectList) {
		this.selectList = selectList;
	}
}
