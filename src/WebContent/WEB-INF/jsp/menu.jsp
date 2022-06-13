<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/tasuma/css/menu.css">
<title>TASUMA | メニュー</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<h2>メニュー</h2>

	<!-- ハンバーガーメニュー -->
	<nav class="menu" id="js-nav">
		<ul class="nav__items nav-items">
			<li class="nav-items__item"><a href="">My資格</a></li>
			<li class="nav-items__item"><a href="">目標設定</a></li>
			<li class="nav-items__item"><a href="">理解度報告</a></li>
			<li class="nav-items__item"><a href="">掲示板</a></li>
			<li class="nav-items__item"><a href="">ユーザ設定</a></li>
			<li class="nav-items__item"><a href="">ログアウト</a></li>
		</ul>
	</nav>
	<button class="menu-btn">
		<span></span>
		<span></span>
		<span></span>
	</button>

	<!-- 中身はJavaBeansが決まらないと書けない(現状はとりあえず仮で書いているだけ) -->

	<!-- 本日の目標 -->
	<%--
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

	--%>

	<!-- カレンダー -->
	<!-- 予定がある場合印付ける→カーソル合わせると詳細表示 -->
	<div id="calendar"></div>

	<script src="JavaScript/menu.js"></script>

	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>