<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/tasuma/css/style.css">
<title>TASUMA | 資格(日程を決める)</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<h2>My資格</h2>
	<h3>資格名</h3>
	<table class="list">
	<form method="post" action="">
	<c:forEach var="e" items="${cardList}" >
		<tr><td><input type="radio" name="select_schedule"></td><td>試験日程1<!-- ${e.testdays} --></td><td></td></tr>
	</c:forEach>
		<tr><td></td><td></td><td><input type="submit" name="regist"></td>
	</form>
	</table>
<!-- アマゾンのリンクを入れるテーブルカラムを用意してない！！！

	<h3>おすすめ参考書</h3>
	<table class="list">
	<tr><td><a href="amazon.com">${a.book_image}</a></td>
	<td><a href="amazon.com">{a.book_name}</a></td></tr>
	</table>
 -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>

//要作業
ユーザ名
メニューに戻る