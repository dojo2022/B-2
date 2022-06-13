<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/tasuma/css/style.css">
<title>TASUMA | メニュー</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<h1>TASUMA</h1>
	<h2>メニュー</h2>
	
	<!-- ハンバーガーメニュー -->
	<nav class="header_nav nav" id="js-nav">
		<button class="menu-button" onclick="location.href='https://codic.jp/engine'"></button>
		<button class="menu-button" onclick="location.href='https://codic.jp/engine'"></button>
		<button class="menu-button" onclick="location.href='https://codic.jp/engine'"></button>
		<button class="menu-button" onclick="location.href='https://codic.jp/engine'"></button>
		<button class="menu-button" onclick="location.href='https://codic.jp/engine'"></button>
		<button class="menu-button" onclick="location.href='https://codic.jp/engine'"></button>
	</nav>
	<button class="header_hamburger hamburger active" id="js-hamburger">
		<span></span>
		<span></span>
		<span></span>
	</button>
	
	<!-- ${ }の中身はJavaBeansが決まらないと書けない(現状はとりあえず仮で書いているだけ) -->
	
	<!-- 本日の目標 -->
	<c:forEach var="e1" items="${Certifications }">
		<h3>本日の目標-${e1.certification}</h3>
		<ul>
			<c:forEach var="e2" items="${e1.Targets }">
				<li>${e2.target }
			</c:forEach>
		</ul>
	</c:forEach>
	
	<!-- 残り日数 -->
	<c:forEach var="e" items="${Certifications }">
		<h4>${e.certification}まで残り${e.date }日です。</h4>
	</c:forEach>
	
	<!-- カレンダー -->
	<!-- 予定がある場合印付ける→カーソル合わせると詳細表示 -->
	<div id="calendar"></div>
	
	<script src="JavaScript/calendar.js"></script>
	
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>