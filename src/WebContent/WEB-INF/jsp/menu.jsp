<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/tasuma/css/menu.css">
<link rel="stylesheet" href="/tasuma/css/style.css">
<script type="text/javascript">

</script>
<script type="text/javascript" src="JavaScript/menu.js" defer></script>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TASUMA|メニュー</title>
</head>
<body>
<%-- 	<input type="hidden" id="getjs" value="${username.username }"> --%>
	<input type="hidden" id="getjs2" value="${username }">
<!-- ヘッダーここから -->
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
<!-- ヘッダーここまで -->

<!-- ユーザ名の表示 -->
	<p class="username">${username.username }</p>
	<h2>メニュー</h2>

<!-- ハンバーガーメニュー -->
<!-- 各リンクの内、サーブレットが未作成のものはとりあえずMenuServletを指定 -->
	<nav class="menu" id="js-nav">
		<ul class="nav__items nav-items">
			<li class="nav-items__item"><a href="/tasuma/CertificationServlet">My資格</a></li>
			<li class="nav-items__item"><a href="/tasuma/MenuServlet">目標設定</a></li>
			<li class="nav-items__item"><a href="/tasuma/UnderstandServlet">理解度報告</a></li>
			<li class="nav-items__item"><a href="/tasuma/MenuServlet">掲示板</a></li>
			<li class="nav-items__item"><a href="/tasuma/UserSettingServlet">ユーザ設定</a></li>
			<li class="nav-items__item"><a href="/tasuma/LoginServlet">ログアウト</a></li>
		</ul>
	</nav>
	<button class="menu-btn">
		<span></span>
		<span></span>
		<span></span>
	</button>

	<!-- 中身はJavaBeansが決まらないと書けない(現状はとりあえず仮で書いているだけ) -->

<!-- 本日の目標 -->
	<c:forEach var="e1" items="${menu_data }">
		<h3>本日の目標-${e1.certification}</h3>
		<ul>
			<c:forEach var="e2" items="${e1.itemList }">
				<li>${e2 }
			</c:forEach>
		</ul>
	</c:forEach>

<!-- 残り日数 -->
	<c:forEach var="e" items="${menu_data }">
		<h4>${e.certification}まで残り${e.testday }日です。</h4>
	</c:forEach>


<!-- カレンダー -->
	<!-- 予定がある場合印付ける→カーソル合わせると詳細表示(余裕があれば) -->

	<button id="prev" type="button">前の月</button>
	<button id="next" type="button">次の月</button>
	<div id="calendar"></div>

<!-- フッターここから -->
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />
<!-- フッターここまで -->
</body>
</html>