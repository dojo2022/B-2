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
			スレッド名※<input type="text" name="thread" id="threadname"><br>
			コメント<textarea name="comment"></textarea><br>

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
			<input type="submit" name="make" value="作成"><br>

			 <!-- 既に利用されているスレッド名を利用しようとした場合のエラー -->
			<div class="errormsg" id="errormsg">${result.message}</div>
		</form>

		<!-- 一覧に戻るボタン -->
		<table>
			<tr class="bbs">
				<td><a href="/tasuma/WEB-INF/bbs.jsp">
						<button type="button" name="back_bbs">一覧に戻る</button>
				</a></td>
			</tr>
		</table>


	</div>



	<!-- フッター -->
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />

</body>
</html>