<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA | 新規スレッド</title>
<link rel="stylesheet" type="text/css"
	href="/tasuma/css/bbs_newthread.css">
<!-- <link rel = "stylesheet"type = "text/css" href = "/tasuma/css/style.css"> -->

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
		<form method="POST" action="/simpleBC/SearchServlet">
			スレッド名※<input type="text" name="thread"><br>
			コメント<input type="text" name="comment"><br>

		<!-- カテゴリプルダウン表示 -->
			<div class="category">
				<label for="select2">カテゴリ※</label>
				<!-- カテゴリをプルダウンで表示 -->
				<select name="select">
					<option value="">選択してください</option>
				</select>
			</div>

		<!-- 作成ボタン -->
		<input type="submit" name="make" value="作成"><br>
		</form>

		<!-- 一覧に戻るボタン -->
		<table>
			<tr class="bbs">
				<td><a href="/tasuma/bbs.jsp">
						<button type="button" name="back_bbs">一覧に戻る</button>
				</a></td>
			</tr>
		</table>


	</div>

		<!-- フッター -->
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />

</body>
</html>