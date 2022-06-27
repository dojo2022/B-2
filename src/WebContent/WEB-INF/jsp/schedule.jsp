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
		<tr class="day_row"><td class="day_row"><label for="${status.index}"><input type="radio" name="select_schedule" value="${e.testdays}" checked="checked" class="radio" id="${status.index}"></label></td><td class="day_row"><h3 class="testday"><label for="${status.index}">${e.testdays}</label></h3></td></tr>
	  </c:when>
	  <c:otherwise>
		<tr class="day_row"><td class="day_row"><label for="${status.index}"><input type="radio" name="select_schedule" value="${e.testdays}" class="radio" id="${status.index}"></label></td><td class="day_row"><h3 class="testday"><label for="${status.index}">${e.testdays}</label></h3></td></tr>
	  </c:otherwise>
	</c:choose>
	</c:forEach>
		<tr><td></td><td></td><td><input type="submit" name="regist" value="登録" class="button"></td></tr>

	</table>
	</form>
	<h3>おすすめ参考書</h3>
	<c:forEach var="a" items="${bookList}">
	<div class="book_item">
		<div class="book_image"><a href="${a.book_url}" target="_blank"><img src="${a.book_image}" alt="参考書画像"></a></div>
		<h3 class="book_name"><a href="${a.book_url}" target="_blank" class="book_url">${a.book_name}</a></h3>
	</div>
	</c:forEach>
	<a href="/tasuma/MenuServlet"><button type="button" name="back_menu" class="back_menu">登録をキャンセルして<br>メニューに戻る</button></a>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>

