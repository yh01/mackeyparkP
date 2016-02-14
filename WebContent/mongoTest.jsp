<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mongoTest</title>
</head>
<body>

	<%-- 表示 --%>
	<label>チケット情報の表示</label>
	<table>
		<tr>
			<th>チケットid</th><th>チケット名</th><th>チケットの値段</th><th>チケットの枚数</th>
		</tr>
			<s:iterator value="commentList">
		<tr>
			<td><s:property value="id"></s:property></td>
		    <td><s:property value="name"></s:property></td>
			<td><s:property value="price"></s:property></td>
			<td><s:property value="quantity"></s:property></td>
		</tr>
		</s:iterator>
	</table>
	<s:form action="MDisplayAction"><s:submit label="チケット情報の表示" type="button" /></s:form>
	<br>
	<br>
	<br>

	<%-- 挿入 --%>
	<label>チケット情報の追加</label>
	<s:form action ="MInsertAction">
		<s:textfield name="id" placeholder="チケットid"></s:textfield>
		<s:textfield name="name" placeholder="チケット名"></s:textfield>
		<s:textfield name="price" placeholder="チケットの値段"></s:textfield>
		<s:textfield name="quantity" placeholder="チケットの枚数"></s:textfield>
		<s:submit label="チケット情報の追加" type="button"/>
	</s:form>
	<br>
	<br>
	<br>

	<%-- 更新 --%>
	<label>チケット情報の更新</label>
	<s:form action="MUpdateAction">
		<s:textfield name="id" placeholder="チケットid"></s:textfield>
		<s:textfield name="name" placeholder="チケット名"></s:textfield>
		<s:textfield name="price" placeholder="チケットの値段"></s:textfield>
		<s:textfield name="quantity" placeholder="チケットの枚数"></s:textfield>
		<s:submit label="チケット情報の更新" type="button" />
	</s:form>
	<br>
	<br>
	<br>

	<%-- 削除 --%>
	<label>チケット情報の削除</label>
	<s:form action="MDeleteAction">
		<s:textfield name="id" placeholder="チケットid"></s:textfield>
		<s:submit label="チケット情報の削除" type="button" />
	</s:form>
	<br>
	<br>
	<br>

	<%-- 挿入 --%>
	<label>お問い合わせ情報の追加</label>
	<s:form action ="MContactInsertAction">
		<s:textfield name="contact_id" placeholder="お問い合わせid"></s:textfield>
		<s:textfield name="contact_name" placeholder="お問い合わせ件名"></s:textfield>
		<s:textarea name="contact" placeholder="内容" ></s:textarea>
		<s:submit label="送信" type="button"/>
	</s:form>
	<br>
	<br>
	<br>

	<%-- 表示 --%>
	<label>お問い合わせ情報の表示</label>
	<table>
		<tr>
			<th>お問い合わせid</th><th>お問い合わせ件名</th><th>内容</th>
		</tr>
			<s:iterator value="contactList">
		<tr>
			<td><s:property value="contact_id"></s:property></td>
		    <td><s:property value="contact_name"></s:property></td>
			<td><s:property value="contact"></s:property></td>
		</tr>
		</s:iterator>
	</table>
	<s:form action="MContactDisplayAction"><s:submit label="お問い合わせの表示" type="button" /></s:form>
	<br>
	<br>
	<br>

</body>
</html>