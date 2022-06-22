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
		<!-- 掲示板のタイトル？に合わせて表示が変わる -->
		<h2>掲示板 - ${thread_bbs }</h2>


		<!-- 投稿されたコメントの表示① -->
		<table class=comments1>
			<!-- 投稿時間と投稿した人のIDを表示する -->
			<tr class="time_bbs">${time_bbs}</tr>
			<td class="user_id">ID：${user_id}</td>
			<!-- 投稿されたコメントを表示する -->
			<textarea name="${content_bbs}"></textarea>
		</table>

		<textarea><name="time_bbs">${time_bbs}<name="user_id">${user_id}</textarea>

${content_bbs}

		<!-- 投稿されたコメントの表示② -->
		<table class=comments2>
			<!-- 投稿時間と投稿した人のIDを表示する -->
			<tr class="time_bbs">${time_bbs}</tr>
			<class="user_id">ID：${user_id}
			<!-- 投稿されたコメントを表示する -->
			<textarea name="${content_bbs}"></textarea>
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