<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|掲示板</title>
<link rel="stylesheet"type="text/css" href="/tasuma/css/bbs_thread.css">
</head>
<body>
	<p class="username">ユーザ名:${username.username}</p>
	<!-- ヘッダー -->
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<h2>掲示板</h2>
	<!-- カテゴリープルダウン選択 -->
	<form method="POST" action="/tasuma/BbsServlet" id="select_bbs" class="select_bbs">
	<table class="thread_category">
	<tr>
	<td>スレッドカテゴリー：<select name="select_bbsCategory">
		<option value="">カテゴリーを選択</option>
		<option value="exam">試験</option>
		<option value="chat">雑談</option>
		<option value="q_a">質問</option>
		<option value="other">その他</option>
	</select></td>
		<td><input type="submit" name="submit" value="検索"class="bbs_selec"></td>
	</tr>
	</table>
	</form>

	<!-- <table class="bbs_list"> -->
		<c:forEach var="e" items="${threadList}" >
		<form method="POST" action="/tasuma/BbsServlet" id="select_bbs" id="select_bbs">
		<table class="bbs_list">
			<tr><td><input type="submit" name="submit" value="${e.thread_bbs}"class="to_thread" ></td></tr>
		</table>
		</form>
		</c:forEach>

	<table>
	<tr>
	<td><button type="button" onclick="location.href='/tasuma/MenuServlet'">メニューへ戻る</button></td>
	<td><button type="button" onclick="location.href='/tasuma/BbsNewServlet'">+</button></td>
	</tr>
	</table>
	<!-- フッター -->
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>