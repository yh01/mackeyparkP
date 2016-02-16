package action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * メイン画面から購入画面に遷移させるためのアクション
 * @author 星野
 *
 */
public class GoMainPurchaseAction extends ActionSupport implements SessionAware{


	/**
	 * ユーザー情報を保存しておくセッション
	 */
	private Map<String, Object> session;


	/**
	 * ポップアップを表示させるためのクラスのインスタンス
	 */
	MainPopUpAction Pop = new MainPopUpAction();


	/**
	 * ユーザー情報を読み取り、その結果の判定をするメソッド
	 * @method Pop.Popup1();ログイン画面に誘導する文言が入力されたポップアップを表示するためのメソッドです。
	 * @method Pop.Popup2();購入画面に誘導する文言が入力されたポップアップを表示するためのメソッドです。
	 * @method Pop.Popup4();情報変更画面に誘導する文言が入力されたポップアップを表示するためのメソッドです。
	 * @return result ユーザー情報からクレジットナンバー下4桁とユーザーidを
	 * 受け取れたらSUCCESS、ユーザーidを受け取れなければERROR、ユーザーidは受け取れて
	 * クレジットナンバー下4桁を受け取れなければcreditErrorを返します。
	 */
	public String execute(){
		String result = "success";
		if(!session.containsKey("user_id") && !session.containsKey("loginId")){
			System.out.println("user_id受け取れてない");
			Pop.Popup1();
			result = ERROR;
		}
		if(session.containsKey("user_id") && !session.containsKey("credit_number")){
			Pop.Popup4();
			result = "creditError";
		}
		if(session.containsKey("loginId") && !session.containsKey("credit_number")){
			Pop.Popup4();
			result = "creditError";
		}
		if(session.containsKey("user_id") && session.containsKey("credit_number") || session.containsKey("token")){
			Pop.Popup2();
			System.out.println("成功");
			result = SUCCESS;
		}
		if(session.containsKey("loginId") && session.containsKey("credit_number") || session.containsKey("token")){
			Pop.Popup2();
			System.out.println("成功");
			result = SUCCESS;
		}
		return result;
	}

	/**
	 * セッションを取得するメソッド
	 * @return session セッション
	 */
	public Map<String, Object> getSession() {
		return session;
	}
	/**
	 * セッションを格納するメソッド
	 * @param session セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

