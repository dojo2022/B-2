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
<div class=wrapper>
<!-- ヘッダーここから -->
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
<!-- ヘッダーここまで -->
	<p class="username">${username.username }</p>
	<h2>理解度報告</h2>

<h3>登録しました。<br>
今日も1日お疲れさまでした。</h3><br>

<!-- 達成度イラストがこの辺に入る？ -->

<a href="/tasuma/MenuServlet">
<button type="button" name="back_menu">メニューに戻る</button>
		</a>
	<!-- フッターここから -->
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	<!-- フッターここまで -->
</div>
</body>
</html>