<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/tasuma/css/style.css">
<link rel="stylesheet" href="/tasuma/css/schedule.css">
<title>TASUMA | 資格(日程を決める)</title>
</head>
<body>
<p class="username">ユーザ名:${username.username}</p>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<h2 id="subtitle">My資格</h2>





	<form method="post" action="/tasuma/ScheduleServlet">


	<h3>資格名:${certification}</h3>

	<table class="list">

	<c:forEach var="e" items="${Test_daysList}" >
		<tr><td></td><td><input type="radio" name="select_schedule" value="${e.testdays}"></td><td>${e.testdays}</td><td></td></tr>
	</c:forEach>
		<tr><td><a href="/tasuma/MenuServlet"><input type="button" name="back_menu" value="メニューに戻る"></a></td><td></td><td></td><td><input type="submit" name="regist" value="登録"></td></tr>

	</table>
	</form>
<!-- アマゾンのリンクを入れるテーブルカラムを用意してない！！！ -->
<!--
	<h3>おすすめ参考書</h3>
	<table class="list">
	<tr><td><a href="amazon.com">参考書画像${a.book_image}</a></td>
	<td><a href="amazon.com">参考書名${a.book_name}</a></td></tr>
	</table>
 -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>

