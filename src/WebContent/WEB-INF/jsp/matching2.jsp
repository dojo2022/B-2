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
<div class="wrapper">
<!-- ヘッダー -->
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<h2>My資格</h2>
<!-- 質問 -->
<p>どのレベルにしますか？</p>
<hr>
<form method="POST" action="/tasuma/Matching2Servlet" id="select_level">
	<table>
	<c:forEach var="e" items="${cardList}" >
	 	<tr>
			<td><input type="radio" name="level" id="selectlevel" value="${e.level}" ></td><td >レベル ${e.level}</td>
		<td><input type="hidden" name="category" value="${e.category}"></td>
		</tr>
	</c:forEach>
	</table>
	<div class="submit"><input type="submit" name="matchingResult" value="結果を見る"class="next"></div>
</form>
<!-- フッター -->
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>