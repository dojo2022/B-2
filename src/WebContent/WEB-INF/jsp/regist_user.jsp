<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|新規会員登録</title>
<link rel="stylesheet"type="text/css" href="/tasuma/css/regist_user.css">
</head>
<body>
<div class="wrapper">
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<h2>新規登録</h2>
<!--
ユーザ名＊
メールアドレス
PW＊
パスワードを表示するチェックボックス
戻るボタン
登録ボタン
のテーブル -->
<form method="POST" action="/tasuma/RegistUserServlet" id="registForm">
	<table>
		<tr>
			<td>ユーザ名 ※<input type="text" name="new_username" id="newUsername"></td>
		</tr>
		<tr>
			<td>メールアドレス <input type="text" name="mail" id="mail"></td>
		</tr>
        <tr>
			<td>PW※<input type="password" name="password" id="newPassword"></td>
		</tr>
		<tr>
			<td><input type="checkbox" id="pw_display">パスワードを表示する </td>
		</tr>
	</table>
	<a href="/tasuma/LoginServlet">
		<button type="button" name="loginReturn" class="loginReturn">戻る</button>
	</a>
    <input type="submit" name="new_register" value="登録" class="regist"><br>
</form>
<span id="error_message"></span>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</div>
<script src="/tasuma/JavaScript/regist_user.js"></script>
</body>
</html>