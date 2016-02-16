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
<link type="text/css" rel="stylesheet"
  href="http://code.jquery.com/ui/1.10.3/themes/cupertino/jquery-ui.min.css" />


<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script>
<!--1国際化対応のライブラリをインポート-->
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/i18n/jquery-ui-i18n.min.js"></script>
<script type="text/javascript">
$(function() {
  // 2日本語を有効化
  $.datepicker.setDefaults($.datepicker.regional['ja']);
  // 3日付選択ボックスを生成
  $('#date').datepicker({ dateFormat: 'yy/mm/dd' });
});
</script>


</head>
<body>
	<div id="main">
	<img src="jpg/themepark.jpg" class="themepark">


		<div id="main_contents">
		<s:form method="POST" action="test">
					<table>
						<tr>
							<th><s:text name="種類"/></th>
							<th><s:text name="備考"/></th>
							<th><s:text name="値段"/></th>
							<th><s:text name="枚数"/></th>
						</tr>
						<s:iterator value="selectList">
							<tr>
								<td><s:property value="division" /></td>
								<td><s:property value="explanation" /></td>
								<td><s:property value="price" /></td>
								<td><s:select name="maisu" list="#{ '0':'0','1':'1','2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10'}" /></td>
							</tr>
						</s:iterator>
					</table>

					<div class="pass" >
						<font color="#ff0000"><s:property value="#session.cans"/></font>
						<br>
						<br>
						パス有効期間を選んでください
						<br>
						<s:select name="kikan" list="#{ '0':'1day','1':'week','2':'month','3':'year'}" />
						<h3>来場希望日</h3><br>
						<s:textfield type="text" id="date" name="date" placeholder="クリックして日付を選択"  size="25"/>
						<br>
						<font color="#ff0000"><s:property value="#session.dans"/></font>
						<br>
						<s:submit cssClass="button9" value="表示"/>
					</div>
		</s:form>
		</div>


		<div id="main_checkbox">
			<div class="checkboxright">
				<s:form action="GoMainPurchaseAction.action"><button class="button9" type="submit">購入</button></s:form>
				<s:form action="GoMainNewUserAction.action"><button class="button8" type="submit">新規登録</button></s:form>
				<s:form action="GoMainLoginAction.action"><button class="button7" type="submit">ログイン</button></s:form>
			</div>
		</div>

	</div>
	<div class="main_clear"></div>
	<h1 align="center">※<span>購入する際はマイページよりクレジットカード情報の登録が必須となります</span></h1>
</body>
</html>