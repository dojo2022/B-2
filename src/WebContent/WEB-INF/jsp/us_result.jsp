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

<!-- 花の画像 -->
<img id='hana1_img' src="/tasuma/img/HANA.png"  width="100" height="100" alt="花" class="hana1">
<!-- ホバー時のテキスト -->
<p class="hana1text">${understands_result.percent[0].item} <br> ${understands_result.percent[0].percent} ％</p>

<!-- 達成度パーセントを格納 -->
< <input id="hana1per" type="hidden" value="${understands_result.percent[0].percent}">



<img id='hana2_img' src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana2">
<p class="hana2text">${understands_result.percent[1].item}<br>${understands_result.percent[1].percent} ％</p>
<input id="hana2per" type="hidden" value="${understands_result.percent[1].percent}">


<img id='hana3_img' src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana3">
<p class="hana3text">${understands_result.percent[2].item}<br>${understands_result.percent[2].percent} ％</p>
<input id="hana3per" type="hidden" value="${understands_result.percent[2].percent}">

<img id='hana4_img' src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana4">
<p class="hana4text">${understands_result.percent[3].item}<br>${understands_result.percent[3].percent} ％</p>
<input id="hana4per" type="hidden" value="${understands_result.percent[3].percent}">

<img id='hana5_img' src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana5">
<p class="hana5text">${understands_result.percent[4].item}<br>${understands_result.percent[4].percent} ％</p>
<input id="hana5per" type="hidden" value="${understands_result.percent[4].percent}">

<img id='hana6_img' src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana6">
<p class="hana6text">${understands_result.percent[5].item}<br>${understands_result.percent[5].percent} ％</p>
<input id="hana6per" type="hidden" value="${understands_result.percent[5].percent}">

<img id='hana7_img' src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana7">
<p class="hana7text">${understands_result.percent[6].item}<br>${understands_result.percent[6].percent} ％</p>
<input id="hana7per" type="hidden" value="${understands_result.percent[6].percent}">

<img id='hana8_img' src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana8">
<p class="hana8text">${understands_result.percent[7].item}<br>${understands_result.percent[7].percent} ％</p>
<input id="hana8per" type="hidden" value="${understands_result.percent[7].percent}">

<img id='hana9_img' src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana9">
<p class="hana9text">${understands_result.percent[8].item}<br>${understands_result.percent[8].percent} ％</p>
<input id="hana9per" type="hidden" value="${understands_result.percent[8].percent}">

<img id='hana10_img' src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana10">
<p class="hana10text">${understands_result.percent[9].item}<br>${understands_result.percent[9].percent} ％</p>
<input id="hana10per" type="hidden" value="${understands_result.percent[9].percent}">

<img id='hana11_img' src="/tasuma/img/HANABIRA.png"  width="45" height="90" alt="花びら" class="hana11">
<p class="hana11text">${understands_result.percent[10].item}<br>${understands_result.percent[10].percent} ％</p>
<input id="hana11per" type="hidden" value="${understands_result.percent[10].percent}">
<!-- 強制改行 -->
<div class="break"></div>
<a href="/tasuma/MenuServlet">
<button type="button" name="back_menu">メニューに戻る</button>
		</a>
	<!-- フッターここから -->
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	<!-- フッターここまで -->
</div>
<script src="/tasuma/JavaScript/us_result.js"></script>
</body>
</html>