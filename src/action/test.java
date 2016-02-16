package action;

import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ParseException;


      public class test extends ActionSupport implements SessionAware{




//変数宣言----------------------------------------------------------------

    	 private Map<String,Object>session;


         private int[] maisu;//チケット枚数の変数

         private String date;//来場日

         private int goukei;//チケットの枚数の合計値を入れる変数

         private int kikan;
         private String path;//パスの有効期間

         public String tans;//エラーメッセージを入れる変数
         public String dans;//同じく

         public boolean x;
         public boolean y;
         public String dd;



//-----------------------------------------------------------------------------------------





         public String execute() throws ParseException, java.text.ParseException{

//チケットが選択されているか判断する--------------------------------------------------------------------

        	 for (int i = 0; i < maisu.length; i++){
        		 goukei += maisu[i];
        		 }


        	 if(goukei==0){

        		        tans="チケットが選択されていません";
        		        session.put("cans",tans );
        		        x=false;

        	 }else{
        		 tans=null;
        		 session.put("cans", tans);
                  x=true;
        		 }



 //来場日が選択されているか判断する-------------------------------------------------------------------
             if(date.length()==0){

 		               dans="来場希望日が選択されていません";
 		               session.put("dans",dans );
 		               y=false;

 	         }else{
 		         dans=null;
 		         session.put("dans", dans);
                 y=true;
 		         }





//パスの期間を判別--------------------------------------------------------------------------------

             switch(kikan){


             case 0: path="1day";
                     break;

             case 1: path="week";
                     break;

             case 2: path="month";
                     break;

             case 3: path="year";
                     break;

             }




//次のページに値を渡すゾーン--------------------------------------------------------------------------
        	  session.put("maisu",maisu );
              session.put("path",path );



              Date date2  = toDate(date);
              session.put("date2",date2 );

//チケット、来場日の判断からもらったbooleanの変数xでERRORかSUCCESSを返す----------------------------------------


              if(x && y){
        		 return SUCCESS;
        	     }


              return ERROR;






         }//executeメソッド終了



         public static Date toDate(String str) throws ParseException, java.text.ParseException {
        	    Date  date = DateFormat.getDateInstance().parse(str);
        	    return date;
        	}

//------以下setter,getter--------------------------------------------------------------

         public String getDd(){
             return dd;
             }

         public void setDd(String dd){
     	    this.dd = dd;
             }




    public String getPath(){
        return path;
        }

    public void setPath(String path){
	    this.path = path;
        }


    public int getKikan(){
        return kikan;
        }

    public void setKikan(int kikan){
	    this.kikan = kikan;
        }

    public String getDate(){
        return date;
        }

    public void setDate(String date){
	    this.date = date;
        }

    public void setMaisu(int[] maisu){
	    this.maisu = maisu;
        }

    public int[] getMaisu(){
        return maisu;
        }


    public Map<String, Object> getSession(){
	   return session;
        }

    public void setSession(Map<String, Object> session){
	   this.session = session;
        }

}