<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA | 新規スレッド</title>
<link rel="stylesheet" type="text/css"
	href="/tasuma/css/bbs_newthread.css">
<!-- <link rel = "stylesheet"type = "text/css" href = "/tasuma/css/style.css"> -->
<script src="./JavaScript/bbs_newthread.js" defer></script>
</head>

<body>

	<!-- ログインしているユーザ名を右上に表示 -->
	<p class="username">ユーザ名：${username.username}</p>

	<div>
		<!-- タイトル -->
		<h1><jsp:include page="/WEB-INF/jsp/header.jsp" /></h1>

		<!-- サブタイトル -->
		<h2>掲示板 - 新規スレッド</h2>

		<!-- スレッド名、コメント、カテゴリプルダウンの入力 -->
		<form method="POST" action="/tasuma/BbsNewServlet">
			<div class= "thread">
			スレッド名※<input type="text" name="thread" id="threadname"></div><br>
			<div class="comment">
			コメント<textarea name="comment" class="comment"></textarea></div><br>

			<!-- カテゴリプルダウン表示 -->
			<div class="category">
				<label for="select2">カテゴリ※</label>
				<!-- カテゴリをプルダウンで表示 -->
				<select name="select" id="category">
					<option value="">選択してください</option>
					<option value="exam">試験</option>
					<option value="chat">雑談</option>
					<option value="q_a">質問</option>
					<option value="other">その他</option>
				</select>
			</div>

		<!-- 作成ボタン -->
		<table>
			<tr class="make">
				<td><a href="/tasuma/BbsThreadServlet">
						<input type="submit" name="make" class="make" value="作成"><br>
				</a></td>
			</tr>
		</table>


			 <!-- 既に利用されているスレッド名を利用しようとした場合のエラー -->
			<div class="errormsg" id="errormsg">${result.message}</div>
		</form>

		<!-- 一覧に戻るボタン -->

	<a href="/tasuma/BbsServlet" class="btn">一覧に戻る</a>

	</div>



	<!-- フッター -->
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />

</body>
</html>