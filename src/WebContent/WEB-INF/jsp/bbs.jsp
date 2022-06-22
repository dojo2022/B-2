<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|掲示板</title>
<link rel="stylesheet"type="text/css" href="/tasuma/css/matching.css">
</head>
<body>
	<p class="username">ユーザ名:${username.username}</p>
	<!-- ヘッダー -->
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<h2>掲示板</h2>
	<!-- カテゴリープルダウン選択 -->
	<p>スレッドカテゴリー：<select name="select_bbsCategory" form="select_bbsCategory">
	<option value="">カテゴリーを選択</option>
	<option value="exam">試験</option>
	<option value="chat">雑談</option>
	<option value="q_a">質問</option>
	<option value="other">その他</option>
	</select></p>
	<form method="POST" action="/tasuma/BbsServlet" id="select_bbs" id="select_bbs">
		<input type="submit" name="bbs_select" value="bbs_select"class="bbs_selec">
	</form>
	<table class="bbs_list">
		<c:forEach var="e" items="${cardList}" >
			<tr><td><a href="/tasuma/BbsNewServlet"></a></td></tr>
		</c:forEach>
	</table>
	<!-- フッター -->
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>