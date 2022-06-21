<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|資格登録|マッチング</title>
<link rel="stylesheet"type="text/css" href="/tasuma/css/matching.css">
</head>
<body>
<!-- ヘッダー -->
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<h2>My資格-結果</h2>
<!-- 質問 -->
<p>あなたにおすすめの資格です！</p>
<hr>
<form method="GET" action="/tasuma/ScheduleServlet" id="matchingResult">
	<table>
	<c:forEach var="e" items="${cardList}" >
		<tr>
			<td ><input type="radio" name="selectCertification" value="${e.certification}" ></td><td id="${e.certification}">${e.certification}</td><td >( レベル ${e.level} )</td>
		</tr>
	</c:forEach>
	</table>
	<div class="submit"><input type="submit" name="toSchedule" value="受験日の選択へ"class="next"></div>
</form>
<!-- フッター -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
<script src="/tasuma/JavaScript/matching.js" ></script>
</html>