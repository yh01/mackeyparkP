<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
						<th><s:text name="種類"/></th>
						<th><s:text name="備考"/></th>
						<th><s:text name="値段"/></th>
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
				<s:form action="GoMainPurchaseAction.action"><button class="button9" type="submit">購入</button></s:form>
				<s:form action="GoMainCreateUserAction.action"><button class="button8" type="submit">新規登録</button></s:form>
				<s:form action="GoMainLoginAction.action"><button class="button7" type="submit">ログイン</button></s:form>
			</div>
		</div>

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
	<div class="main_clear"></div>
	<h1 align="center">※<span>購入する際はマイページよりクレジットカード情報の登録が必須となります</span></h1>
</body>
</html>