<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.sql.*"%>
<%@ page import="util.DBconnector"%>
<%@ page import="dto.LoginDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メイン</title>


<link rel="stylesheet" type="text/css" href="css/05.main.css">
<link rel="stylesheet" type="text/css" href="css/06.select.css">
<link rel="stylesheet" type="text/css" href="css/botan.css">
<link rel="stylesheet" type="text/css" href="css/botan2.css">
<link rel="stylesheet" type="text/css" href="css/23.24.header_footer.css">
<link type="text/css" rel="stylesheet"
  href="http://code.jquery.com/ui/1.10.3/themes/cupertino/jquery-ui.min.css" />


<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
<!--1国際化対応のライブラリをインポート-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/i18n/jquery-ui-i18n.min.js"></script>
<script>
    $(function() {
        $( "#sample-button" ).click(function() {
            alert("ok");

            alert("ok2");

        });
    });

    $(function() {
        $( "#goPur" ).click(function() {
            alert("購入画面に遷移します");
        });
    });

    $(function() {
        $( "#goMy" ).click(function() {
            alert("クレジットカード情報が無いのでマイページに遷移します");
        });
    });

    $(function() {
        $( "#alLogged" ).click(function() {
            alert("ログイン済みです。戻ります");
        });
    });
</script>
</head>
<body>
<!--ログイン非ログインの判別-->
<%
	String mailAdress = (String)session.getAttribute("mail_adress");
	boolean LoginState;
	if(mailAdress==null){
		LoginState=false;
	}else{
		LoginState=true;
	}
%>
<!--クレジット情報取得-->
<%
	class getCledit{
		Connection con;
		String sql;
		PreparedStatement stmt;
		ResultSet resultSet;
		public void selectCledit(String mailAdress, LoginDTO dto){
			try {
				con = (Connection)DBconnector.getConnection("openconnect");
				sql = "SELECT credit_number FROM user WHERE mail_address = ? ";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, mailAdress);
				resultSet = stmt.executeQuery();
				if (resultSet.next()) {
					dto.setCredit_number(resultSet.getString("credit_number"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
%>

<%
	getCledit gC = new getCledit();
	LoginDTO dto = new LoginDTO();
	gC.selectCledit(mailAdress, dto);
	String token = dto.getCredit_number();
	boolean tokenState;
	if(token == null){
		tokenState = false;
	}else{
		tokenState = true;
	}
%>

<%if(tokenState){%>
	<script>
	    $(function() {
	        $( "#sample-button2" ).click(function() {
	            alert("tokenOk");
	        });
	    });
	</script>
<%} %>

<!--ヘッダー全部ここから-->
	<!--ログアウト時ヘッダー-->
<%if(LoginState==false){ %>
	<div id="header">

		<a href="#" class="header-left"><img
			src="http://free-illustrations-ls01.gatag.net/images/lgi01a201409170000.jpg"
			class="sample"></a>

		<div class="ribbon">
				<s:a href="GoMainAction"><span>トップ</span></s:a>
			 	<s:a href="GoCreateUserAction"><span>新規登録</span></s:a>
			 	<s:a href="GoUserLoginAction"><span>ログイン</span></s:a>
		</div>
	</div>
<%} %>

	<!--ログイン時ヘッダー-->
<% if(LoginState==true){%>
	<div id="header">

		<a href="#" class="header-left"><img
			src="http://free-illustrations-ls01.gatag.net/images/lgi01a201409170000.jpg"
			class="sample"></a>

		<div class="ribbon">
				<s:a href="GoMainAction"><span>トップ</span></s:a>
				<s:a href="GoMyPageAction"><span>マイページ</span></s:a>
				<s:a href="GoUserLogoutAction"><span>ログアウト</span></s:a>
		</div>
	</div>
<%} %>
<!--ヘッダー全部ここまで-->
	<div id="main">
	<img src="jpg/themepark.jpg" class="themepark">


		<div id="main_contents">
			<div class="checkbox">
				<table>
					<tr>
						<th><s:text name="%{getText('main.kind')}"/></th>
						<th><s:text name="%{getText('main.remarks')}"/></th>
						<th><s:text name="%{getText('main.price')}"/></th>
					</tr>
						<s:iterator value="selectList">
							<tr>
								<td><s:property value="division" /></td>
								<td><s:property value="explanation" /></td>
								<td><s:property value="price" /></td>
							</tr>
						</s:iterator>
				</table>
			</div>
		</div>


		<div id="main_checkbox">
			<div class="checkboxright">
				<%if(LoginState==true && tokenState==true){ %>
				<s:form action="GoMainPurchaseAction.action"><button class="button9" type="submit" id="goPur"><s:text name="%{getText('main.pur')}"/></button></s:form>
				<%} %>

				<%if(LoginState==true && tokenState==false){ %>
				<s:form action="GoMainPurchaseAction.action"><button class="button9" type="submit" id="goMy"><s:text name="%{getText('main.pur')}"/></button></s:form>
				<%} %>

				<%if(LoginState==false){ %>
				<button class="button9" data-toggle="modal" data-target="#sampleModal" type="submit"><s:text name="%{getText('main.pur')}"/></button>
				<%} %>

				<s:form action="GoMainCreateUserAction.action"><button class="button8" type="submit" id="sample-button"><s:text name="%{getText('main.CUser')}"/></button></s:form>


				<%if(LoginState==true){ %>
				<s:form action="GoMainLoginAction.action"><button class="button7" type="submit" id="alLogged"><s:text name="%{getText('main.login')}"/></button></s:form>
				<%} %>

				<%if(LoginState==false){ %>
				<button class="button7" data-toggle="modal" data-target="#sampleModal" type="submit"><s:text name="%{getText('main.login')}"/></button>
				<%} %>
			</div>
		</div>
		<a id="sample-button2">a</a>
	<div class="main_clear"></div>
	<div id="main_func"><h1 align="center"><span>※<s:text name="%{getText('main.func')}"/></span></h1></div>
	</div>

	<!--フッター全部ここから-->
	<!--ログアウト時フッター-->
<%if(LoginState==false){ %>
	<div id="footer">
		<div class="footer-right">
			<ul>
					<li><s:a href="GoCompanyAction">会社概要</s:a></li>
					<li><s:a href="GoTeamsOfServiceAction">利用規約</s:a></li>
					<li><s:a href="GoHelpAction">Q&amp;A</s:a></li>
			</ul>
		</div>
	</div>
<%} %>
	<!--ログイン時フッター-->
<%if(LoginState==true){ %>
	<div id="footer">
		<div class="footer-right">
			<ul>
					<li><s:a href="GoWithdrawalConfirmAction">退会画面</s:a></li>
					<li><s:a href="GoCompanyAction">会社概要</s:a></li>
					<li><s:a href="GoTeamsOfServiceAction">利用規約</s:a></li>
					<li><s:a href="GoHelpAction">Q&amp;A</s:a></li>
			</ul>
		</div>
	</div>
<%} %>
<!--フッター全部ここまで-->
<jsp:include page="/login.jsp" />
</body>
</html>