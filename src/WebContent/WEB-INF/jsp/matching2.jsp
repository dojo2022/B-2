<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|資格登録|マッチング</title>
</head>
<body>
<div class="wrapper">
<!-- ヘッダー -->
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<h2>My資格</h2>
<!-- 質問 -->
<c:forEach var="e" items="${cardList}" >
<form method="POST" action="/tasuma/Matching2Servlet" id="matching">
	<table>
	<caption>どのレベルにしますか？</caption>
	 	<tr>
			<td><input type="radio" name="selectlevel" id="selectlevel"></td><td >${e.level}</td>
		</tr>
	</table>
	<div class="submit"><input type="submit" name="matching_result" value="次へ"class="matching_result"></div>
</form>
</c:forEach>
<!-- フッター -->
</div>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>