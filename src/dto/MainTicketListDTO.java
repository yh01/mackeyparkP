package dto;

/**
 * @author 星野
 *メイン画面に表示するチケット一覧のリスト情報を取得、格納するためのクラス
 */
public class MainTicketListDTO {


	/**
	 * チケットの種類
	 */
	private String division;


	/**
	 * 備考
	 */
	private String explanation;


	/**
	 * チケットの値段
	 */
	private int price;


	/**
	 * メイン画面に表示するチケットの種類を取得するためのメソッド
	 * @return
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * メイン画面に表示するチケットの種類を格納するためのメソッド
	 * @param division
	 */
	public void setDivision(String division) {
		this.division = division;
	}

	/**
	 * メイン画面に表示する備考を取得するためのメソッド
	 * @return
	 */
	public String getExplanation() {
		return explanation;
	}


	/**
	 * メイン画面に表示する備考を格納するためのメソッド
	 * @param explanation
	 */
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}


	/**
	 * メイン画面に表示するチケットの値段を取得するためのメソッド
	 * @return
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * メイン画面に表示するチケットの値段を格納するためのメソッド
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
}
