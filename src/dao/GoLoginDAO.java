package dao;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GoLoginDAO extends JFrame implements ChangeListener{
	public void actionPerformed1(){
		JLabel label = new JLabel("ログインしてないのでログイン画面に遷移します。");
		label.setForeground(Color.BLACK);
		JOptionPane.showMessageDialog(this, label);
	}
	public void actionPerformed2(){
		JLabel label = new JLabel("ログイン済みです。メイン画面に戻ります。");
		label.setForeground(Color.BLACK);
		JOptionPane.showMessageDialog(this, label);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}
}