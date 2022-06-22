<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|理解度報告</title>
<link rel="stylesheet" href="/tasuma/css/us_result.css">
<link rel="stylesheet" href="/tasuma/css/style.css">
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

<!--ページ内に図形を描画するキャンバスを用意 -->
<canvas id="tasuma" width="960" height="640"></canvas>

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