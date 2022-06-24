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

	<c:forEach var="e" items="${Test_daysList}" varStatus="status">
	<c:choose>
	  <c:when test="${status.index == 0}">
		<tr><td></td><td><input type="radio" name="select_schedule" value="${e.testdays}" checked="checked" class="radio"></td><td><h3 class="testday">${e.testdays}</h3></td><td></td></tr>
	  </c:when>
	  <c:otherwise>
	  		<tr><td></td><td><input type="radio" name="select_schedule" value="${e.testdays}" class="radio"></td><td><h3 class="testday">${e.testdays}</h3></td><td></td></tr>
	  </c:otherwise>
	</c:choose>
	</c:forEach>
		<tr><td><a href="/tasuma/MenuServlet"><input type="button" name="back_menu" value="メニューに戻る"></a></td><td></td><td></td><td><input type="submit" name="regist" value="登録"></td></tr>

	</table>
	</form>
	<h3>おすすめ参考書</h3>
	<c:forEach var="a" items="${bookList}">
	<div class="book_item">
		<div class="book_image"><a href="${a.book_url}" target="_blank" alt="参考書画像とアマゾンリンク"><img src="/tasuma/img/book_img${a.book_image}.jpg"></a></div>
		<h3 class="book_name"><a href="${a.book_url}" target="_blank" class="book_url">${a.book_name}</a></h3>
	</div>
	</c:forEach>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>

