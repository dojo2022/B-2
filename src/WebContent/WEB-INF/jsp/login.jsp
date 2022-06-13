<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|ログイン</title>
<link rel="stylesheet"type="text/css" href="/tasuma/css/login.css">
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<!--新規登録ページにリンク飛ぶボタン-->
 <a href="/tasuma/MenuServlet">
	<button type="button" name="newregister">新規登録</button>
</a>
<!--
ユーザ名・PWの入力欄
ログインボタン
パスワードを表示するチェックボックス
のテーブル-->
<form method="POST" action="/tasuma/LoginServlet" id="loginForm">
	<table>
	 	<tr>
			<td>ユーザ名<input type="text" name="username_box" id="username"></td>
		</tr>
		<tr>
			<td>PW<input type="password" name="password" id="password"></td>
		</tr>
		<tr>
			<td><input type="checkbox" id="pw_display">パスワードを表示する </td>
		</tr>
	</table>
	<div class="submit"><input type="submit" name="login" value="Enter"class="login"></div>
</form>
<span id="error_message"></span>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<script src="/tasuma/WebContent/JavaScript/login.js"></script>
</body>
</html>