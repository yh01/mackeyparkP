package action;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * メイン画面にて、ポップアップ表示を行うためのクラス
 * @author 星野
 *
 */
public class MainPopUpAction extends JFrame implements ChangeListener{


	/**
	 * ログイン画面に誘導する文言が入力されたポップアップを表示するためのメソッド
	 */
	public void Popup1(){
		JLabel label = new JLabel("ログインしてないのでログイン画面に遷移します。");
		label.setForeground(Color.BLACK);
		JOptionPane.showMessageDialog(this, label);
	}


	/**
	 * 購入画面に誘導する文言が入力されたポップアップを表示するためのメソッド
	 */
	public void Popup2(){
		JLabel label = new JLabel("購入画面に遷移します。");
		label.setForeground(Color.BLACK);
		JOptionPane.showMessageDialog(this, label);
	}


	/**
	 * ログイン済みを知らせる文言が入力されたポップアップを表示するためのメソッド
	 */
	public void Popup3(){
		JLabel label = new JLabel("ログイン済みです。メイン画面に遷移します。");
		label.setForeground(Color.BLACK);
		JOptionPane.showMessageDialog(this, label);
	}


	/**
	 * 情報変更画面に誘導する文言が入力されたポップアップを表示するためのメソッド
	 */
	public void Popup4(){
		JLabel label = new JLabel("ログイン済みですがクレジットカード情報が不足しています。マイページで登録してください。");
		label.setForeground(Color.BLACK);
		JOptionPane.showMessageDialog(this, label);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
