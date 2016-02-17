package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * メイン画面からログイン画面に遷移させるためのアクションクラス
 * @author 星野
 *
 *
 */
public class GoMainLoginAction extends ActionSupport implements SessionAware{
	/**
	 *  ユーザー情報を保存しておくセッション
	 */
	private Map<String, Object> session;
	/**
	 * ポップアップを表示させるためのクラスのインスタンス
	 */
	MainPopUpAction Pop = new MainPopUpAction();


	/**
	 * ユーザー情報を読み取り、その結果の判定をするメソッド
	 *@method Pop.Popup3();ログイン済みであることを知らせる文言が入力されたポップアップを表示するためのメソッドです。
	 *@return result ユーザー情報からユーザーidを受け取れればSUCCESS、受け取れなければERRORを返します。
	 */
	public String execute(){
		if(session.containsKey("user_id")){
			Pop.Popup3();
			System.out.println("成功");
			return "success";
		}else if(session.containsKey("loginId")){
			Pop.Popup3();
			System.out.println("成功");
			return "success";
		}
		Pop.Popup1();
		System.out.println("失敗");
		return "error";
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
