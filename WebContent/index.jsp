<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, java.util.Arrays, java.util.List" %>
<%
	List<String> color = new ArrayList<String>(Arrays.asList("赤","黄","青"));
	color.add("オレンジ");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
	<p>ここ
		<% if(color.contains("青")) { %>
		<%= color.contains("青") %>
		<% } %>
	</p>
	<h1>どこつぶへようこそ</h1>
	<form action="/docoTsubu/Login" method="post">
		ユーザー名：<input type="text" name="name"><br>
		パスワード：<input type="password" name="pass"><br>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>