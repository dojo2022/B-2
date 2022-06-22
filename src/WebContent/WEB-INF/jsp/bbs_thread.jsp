<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA | 掲示板</title>
<link rel="stylesheet" type="text/css" href="/tasuma/css/bbs_thread.css">
<!-- <link rel = "stylesheet"type = "text/css" href = "/tasuma/css/style.css"> -->
</head>
<body>

	<!-- 各スレッド画面ページ -->

	<!-- ログインしているユーザ名を右上に表示 -->
	<p class="username">ユーザ名：${username.username}</p>

	<div>
		<!-- タイトル -->
		<h1><jsp:include page="/WEB-INF/jsp/header.jsp" /></h1>

		<!-- サブタイトル -->
		<h2>掲示板 - 基本情報技術者試験</h2>


		<!-- 投稿されたコメントの表示 -->
		<table class = comments>
			<textarea name="comment1"></textarea>
			<br>
			<textarea name="comment2"></textarea>
			<br>
		</table>



		<!-- 投稿する時の処理 -->
		<form method="POST" action="/tasuma/BbsThreadServlet">
			<!-- 投稿するユーザ名を表示 -->
			<p class="username">ID：${username.username}</p>
			<textarea name="post1"></textarea>
			<!-- 投稿ボタン -->
			<input type="submit" name="post" value="投稿"><br>
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