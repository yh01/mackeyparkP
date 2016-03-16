<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/01.Login.css" />
<title>Insert title here</title>
</head>
<body>
<h1>ログイン</h1>
<div class="skin">
	<h3>下記に情報を入力してください。</h3><br>
	<!-- ログインエラーメッセージ -->
	<div class="errorMsg">
		<s:property value="ErrorMsg"/>
	</div>

<!-- ログイン -->
	<s:form action="LoginAction" namespace="/" theme="simple">
		<table>
			<tr>
			<td>ID(メールアドレス):</td>
			<td><s:textfield name="mail_adress" /></td>
			</tr>
			<tr>
			<td>パスワード :</td>
			<td><s:password name="password"  /></td>
			</tr>
		</table>
		<s:submit cssClass="loginBtn"  value="ログイン"/>
	</s:form>
		<ul>
		<li>SNS認証はこちら</li>
		<!-- フェイスブック  -->
		<li><s:url var="facebook" action="login-facebook"/>
       	<s:a href="%{facebook}" ><img src="img/Facebook.jpg" ></s:a></li>

        <!-- ツイッター -->
        <li><s:url var="twitter" action="login-twitter" />
        <s:a href="%{twitter}"><img src="img/twitter.jpg" ></s:a></li>

		<!-- グーグル  -->
		<li><s:url var="google" action="login-google" />
        <s:a href="%{google}"><img src="img/GooglePlusIcon.jpg"></s:a></li>
        </ul>
</div>
<p>登録していない方はこちらから新規登録してください</p>
</body>
</html>