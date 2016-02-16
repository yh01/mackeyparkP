<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/01.Login.css" />
<title>Insert title here</title>
</head>
<body>

<h1>ログイン</h1>

<div class="skin">

	<h3>下記に情報を入力してください。</h3><br>

<!-- ログインエラーメッセージ -->
<div class="errorMsg"><s:property value="ErrorMsg"/></div>

<!-- ログイン -->
	<s:form action="LoginAction" namespace="/">
		<table>
		<tr>
		<td><h4>ID(メールアドレス): <s:textfield name="mail_adress" /></h4></td>
		</tr>
		<tr>
		<td><h4>パスワード :　　　　　<s:password name="password"  /><br></h4></td>
		</tr>
		</table>
	<s:submit cssClass="loginBtn"  value="ログイン"/>
</s:form>

<br>
<br>
		<ul>
		<li>SNS認証はこちら</li>
		<!-- フェイスブック  -->
		<li><s:url var="facebook" action="login-facebook"/>
       	<s:a href="%{facebook}" ><img src="img/Facebook-j.jpg" style="zoom: 40%;"></s:a></li>

        <!-- ツイッター -->
        <li><s:url var="twitter" action="login-twitter" />
        <s:a href="%{twitter}"><img src="img/twitter-j.jpg" style="zoom: 20%;"></s:a></li>

		<!-- グーグル  -->
		<li><s:url var="google" action="login-google" />
        <s:a href="%{google}"><img src="img/google-j.jpg" style="zoom: 32%;"></s:a></li>
        </ul>
</div>

	<p>登録していない方はこちらから新規登録してください</p>

</body>
</html>