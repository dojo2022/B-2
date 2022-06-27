<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|掲示板</title>
<link rel="stylesheet"type="text/css" href="/tasuma/css/bbs.css">
</head>
<body>
	<p class="username">ユーザ名:${username.username}</p>
	<!-- ヘッダー -->
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<h2>掲示板</h2>
	<!-- カテゴリープルダウン選択 -->

	<div class="bbs_list">
	<form method="POST" action="/tasuma/BbsServlet" id="select_bbs" class="select_bbs">
	<table>
	<tr>
	<td class=thread_category><select name="select_bbsCategory">
		<option value="">カテゴリーを選択</option>
		<option value="exam">試験</option>
		<option value="chat">雑談</option>
		<option value="q_a">質問</option>
		<option value="other">その他</option>
	</select></td>
	<td></td>
		<td class="c_submit"><input type="submit" name="submit" value="検索"class="selec"></td>
		</tr>
		</table>
	</form>

		<c:forEach var="e" items="${threadList}" >
		<form method="POST" action="/tasuma/BbsServlet" id="select_bbs" id="select_bbs">
		<table class="bbs_list">
			<tr><td><input type="submit" name="submit" value="${e.thread_bbs}"class="to_thread" ></td></tr>
		</table>
		</form>
		</c:forEach>
	<div class="btns">
	<button type="button" onclick="location.href='/tasuma/MenuServlet'" class="to_menu">戻る</button>
	<button type="button" onclick="location.href='/tasuma/BbsNewServlet'" class="btn">+</button>
	</div>
	</div>
	<!-- フッター -->
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>