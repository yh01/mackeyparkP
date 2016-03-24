package com.internousdevwork.mackeypark.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdevwork.mackeypark.util.DBConnector;

/**
 * カートや購入に関するデータを扱うDAOクラス
 * @author SHIZUKA IMANISHI
 * @version 1.0
 * @since 1.0
 **/
public class GoSelectConditionDAO {

    /**
     * データベースに接続するためのインターフェース
     */
    private Connection con;

    /**
     * SQL文
     */
    private String sql;

    /**
     * SQL文を実行するためのインターフェース
     */
    private PreparedStatement ps;

    /**
     * 結果を格納するインターフェース
     */
    private ResultSet rs;

    /**
     * 検索結果の有無
     */
    private boolean isResult;

    /**
     * openconnectデータベースのuserテーブルより、idを条件に検索しtokenの有無を確認するメソッド
     * @param id ユーザーID
     * @return isResult 更新結果の有無を返します。
     */
    public boolean selectToken(int id){
        isResult = false;
        try{
            con = DBConnector.getConnection("openconnect");
            sql ="SELECT credit_token FROM user WHERE id = ? AND credit_token ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                isResult = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return isResult;
    }
}