package dto;


/**
 * ユーザーのクレジット情報を格納するクラス
 * @author K.sugano
 * @version 1.0
 * @since 1.0
 */
public class CreditCheckDTO {

	/**
	 * クレジットカード番号
	 */
	private int creditNum;

	/**
	 * クレジットトークン
	 */
	private String creditToken;

	/**
	 * クレジットカード番号を取得するメソッド
	 * @return creditNum クレジットカード番号
	 */
	public int getCreditNum() {
		return creditNum;
	}

	/**
	 * クレジットカード番号を格納するメソッド
	 * @param creditNum クレジットカード番号
	 */
	public void setCreditNum(int creditNum) {
		this.creditNum = creditNum;
	}

	/**
	 * クレジットトークンを取得するメソッド
	 * @return creditToken クレジットトークン
	 */
	public String getCreditToken() {
		return creditToken;
	}

	/**
	 * クレジットトークンを格納するメソッド
	 * @param creditToken クレジットトークン
	 */
	public void setCreditToken(String creditToken) {
		this.creditToken = creditToken;
	}
}
