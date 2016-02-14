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
<link rel="stylesheet" type="text/css" href="css/botan2.css">
<link href="jquery-ui-1.11.4.custom/external/jquery/jquery.js">
    <script src="jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
    <script src="jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
	<%String login=(String) session.getAttribute("id");%>
	<script>
	    $(function() {
	        $( "#pur-button" ).click(function() {
	        	if(<%=(String) session.getAttribute("id")%>){
	        		alert("購入画面に遷移");
	        	}else{
	        		alert("ログインしてください");
	        	}
	        });
	    });
    </script>
    <script>
	    $(function() {
	        $( "#newuser-button" ).click(function() {
	            alert("新規登録画面に遷移します。");
	        });
	    });
    </script>
    <script>
	    $(function() {
	        $( "#login-button" ).click(function() {
	            alert("ログイン画面に遷移します。");
	        });
	    });
    </script>
<style>

</style>
</head>
<body>
	<div id="main">
	<img src="jpg/themepark.jpg" class="themepark">
			<div class="checkbox">
					<table>
					<tr>
						<th>チケット</th>	<th>チケット要約</th> <th>値段</th>
					</tr>
					<tr>
						<td>シニア</td>	<td>65才以上向けです</td><td>1234円（税込み?）</td>
					</tr>
					<tr>
						<td>学生</td>	<td>学生向け</td><td>1234円（税込み?）</td>
					</tr>
					<tr>
						<td>幼児</td>	<td>幼児向け</td><td>1234円（税込み?）</td>
					</tr>
					<tr>
						<td>団体</td>	<td>15名様からのご予約になります</td><td>1234円（税込み?）</td>
					<tr>
						<td>バースデー</td>	<td>誕生日の方に</td><td>1234円（税込み?）</td>
					</tr>
					<tr>
						<td>一般</td>	<td>一般</td><td>1234円（税込み?）</td>
					</tr>
					<tr>
						<td>ナイト</td>	<td>8時からのご入場</td><td>1234円（税込み?）</td>
					</tr>
					<tr>
						<td>アフター６</td>	<td>6時からのご入場</td><td>1234円（税込み?）</td>
					</tr>
					</table>

					<div class="checkboxright">
						<s:form action="GoPurchaseAction.action"><button class="button9" type="submit" id="pur-button">購入</button></s:form>
						<s:form action="GoNewUserAction.action"><button class="button8" type="submit" id="newuser-button">新規登録</button></s:form>
						<s:form action="GoLoginAction.action"><button class="button7" type="submit" id="login-button">ログイン</button></s:form>
					</div>
			</div>
			<h1 align="center">※<span>購入する際はマイページよりクレジットカード情報の登録が必須となります</span></h1>
	</div>
</body>
</html>