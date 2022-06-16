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
<div class=wrapper>
<!--新規登録ページにリンク飛ぶボタン-->
<a href="/tasuma/RegistUserServlet">
	<button type="button" name="newregister" class="newregist_button">新規登録</button>
</a>
<!-- ヘッダー -->
<jsp:include page="/WEB-INF/jsp/header.jsp" />


<!--
ユーザ名・PWの入力欄
ログインボタン
パスワードを表示するチェックボックス
のテーブル-->
<form method="POST" action="/tasuma/LoginServlet" id="loginForm">
	<table>
	 	<tr>
			<td class="title">ユーザ名</td><td class="box"><input type="text" name="username" id="username"></td>
		</tr>
		<tr>
			<td class="title">PW</td><td class="box"><input type="password" name="password" id="password"></td>
		</tr>
		<tr>
			<td><input type="checkbox" id="pw_display" class="box">パスワードを表示する </td>
		</tr>
	</table>
	<div class="submit"><input type="submit" name="login" value="ログイン"class="login"></div>
</form>
<span id="error_message"></span>
<div class="errormsg">${result.message}</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</div>
<script src="/tasuma/JavaScript/login.js" defer></script>

</body>
</html>