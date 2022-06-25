<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

		<h2>掲示板 -${comments.thread_bbs}</h2>



		<!-- 投稿されたコメントの表示(投稿された順番に） -->
		<table class="bbs">
		<c:forEach var="e" items="${comments.comment_bbs}">
				<!-- 投稿時間と投稿した人のIDを表示する -->
				<tr class="rowdata">
					<td class = time_bbs>${e.time_bbs}ID：${e.username}</td>
					<!-- 投稿されたコメントを表示する -->
					<td class = comment>${e.content_bbs}</td>
				</tr>
		</c:forEach>
			</table>

		<!-- 投稿する時の処理 -->
		<form method="POST" action="/tasuma/BbsThreadServlet">
			<!-- 投稿するユーザ名を表示 -->
			<!--セッションスコープのスレッドのidを入れる  -->
			<input type="hidden" name="thread_no" value="${comments.thread_bbs}">
			<p class="username_comment">ID：${username.username}</p>
			<textarea name="post1" class="comment_box"></textarea>
			<input type="hidden" name="getThreadId" value="${comments.thread_id}">
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