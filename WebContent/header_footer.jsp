<!-- ログイン機構が完成した後調整するので今は放置で -->

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href=".//css/23.24.header_footer.css">
<link rel="stylesheet" type="text/css"
	href="/*ここに作成したcssファイルのURLを入れてみてください*/">
<title>ヘッダー＿フッターログイン前</title>
</head>
<body>
<!--ログイン非ログインの判別-->
<%
	String id = (String)session.getAttribute("user_id");
	boolean LoginState;
	if(id==null){
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
	<div id="main">/*ここに作成したhtmlの内容を入れてみてください*/</div>



	<div id="footer_bk"></div>
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
</body>
</html>