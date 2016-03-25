<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title><s:text name ="mypage_my"/></title>
<link rel="stylesheet" type="text/css" href="css/botan.css" media="all" />
<link rel="stylesheet" type="text/css" href="css/11.mypage.css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/i18n/jquery-ui-i18n.min.js"></script>
<script type="text/javascript">
$(function() {
  $.datepicker.setDefaults($.datepicker.regional['ja']);
  $('#date').datepicker({ dateFormat: 'yy/mm/dd' });
});
</script>
<s:if test="%{popup == 1}">
    <script type="text/javascript">alert("クレジット情報が不足しているので、マイページに遷移します。");</script>
</s:if>
</head>
<body>
<%-- <jsp:include page="header.jsp" /> --%>
	<div id=main>
		<div id = "mypage_main" align="center">
		<p class="form-title"><s:text name="%{getText('mypage_my')}"/></p>
			<table id ="form">
				<tr>
					<td><s:text name="%{getText('mypage_user')}"/></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td><s:text name="%{getText('mypage_name')}"/></td>
					<td><s:property value="userName"/></td>
				</tr>
				<tr>
					<td><s:text name="%{getText('mypage_kana')}"/></td>
					<td><s:property value="nameKana"/></td>
				</tr>
				<tr>
					<td><s:text name="%{getText('mypage_ps')}"/></td>
					<td><s:text name="%{getText('mypage_sec')}"/></td>
				</tr>
				<tr>
					<td><s:text name="%{getText('mypage_Id')}"/></td>
					<td><s:property value="email"/></td>
				</tr>

			</table>
		<br>
		<s:form action="GoEditUserAction">
			<button class="button9" type="submit"><s:text name ="mypage_change"/></button>
		</s:form>
		</div>
	</div>
<%-- 		<jsp:include page="footer.jsp" /> --%>
</body>
</html>