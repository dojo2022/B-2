<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|新規会員登録</title>
<link rel="stylesheet"type="text/css" href="/tasuma/css/login.css">
</head>
<body>
<header><%@ include file="/WebContent/WEB-INF/jsp/header.jsp" %></header>
<h2>新規登録</h2>
<!--
ユーザ名＊
メールアドレス
PW＊
パスワードを表示するチェックボックス
戻るボタン
登録ボタン
のテーブル -->
<form method="POST" action="/tasuma/RegistUserServlet">
	<table>
		<tr>
			<td>ユーザ名 ※<input type="text" name="new_username"t></td>
		</tr>
        <tr>
			<td>PW<input type="password" name="password" id="password"></td>
		</tr>
		<tr>
			<td><input type="checkbox" id="pw_display">パスワードを表示する </td>
		</tr>
	</table>
    <input type="submit" name="new_register" value="登録"><br>
</form>
<!--<span id="error_message"></span>-->
<footer><%@ include file="/WebContent/WEB-INF/jsp/footer.jsp" %></footer>
<script src="/tasuma/WebContent/JavaScript/regist_user.js"></script>
</body>
</html>