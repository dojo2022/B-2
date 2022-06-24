<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|理解度報告</title>
<link rel="stylesheet" href="/tasuma/css/us_result.css">
</head>
<body>
	<p class="username">ユーザ名:${username.username }</p>
<div class=wrapper>
<!-- ヘッダーここから -->
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
<!-- ヘッダーここまで -->

	<h2>理解度報告</h2>

<h3>登録しました。<br>
今日も1日お疲れさまでした。</h3><br>

<img src="/tasuma/img/HANA.png"  width="100" height="100" alt="花" class="hana1">
<p class="hana1text">${understands_result.percent[0].item} <br> ${understands_result.percent[0].percent} ％</p>
<img src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana2">
<p class="hana2text">第2章<br>達成率 ％</p>
<img src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana3">
<p class="hana3text">第3章<br>達成率 ％</p>
<img src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana4">
<p class="hana4text">第4章<br>達成率 ％</p>
<img src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana5">
<p class="hana5text">第5章<br>達成率 ％</p>
<img src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana6">
<p class="hana6text">第6章<br>達成率 ％</p>
<img src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana7">
<p class="hana7text">第7章<br>達成率 ％</p>
<img src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana8">
<p class="hana8text">第8章<br>達成率 ％</p>
<img src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana9">
<p class="hana9text">第9章<br>達成率 ％</p>
<img src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana10">
<p class="hana10text">第10章<br>達成率 ％</p>
<img src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana11">
<p class="hana11text">第11章<br>達成率 ％</p>
<div class="break"></div>
<a href="/tasuma/MenuServlet">
<button type="button" name="back_menu">メニューに戻る</button>
		</a>
	<!-- フッターここから -->
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	<!-- フッターここまで -->
</div>
<script src="/tasuma/JavaScript/understand_result.js"></script>
</body>
</html>