package action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * メイン画面から新規登録画面に遷移させるためのアクションクラス
 * 常にSUCCESSを返します。
 * @author 星野
 *
 */
public class GoMainNewUserAction extends ActionSupport{
	public String excecute(){
		return SUCCESS;
	}
}
