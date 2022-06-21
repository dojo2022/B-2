<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="e" items="${resultList}" >
	項目id:${e.item_id}<br>
	目標id:${e.target_id}
	</c:forEach>
<!--	・ユーザ名
		・資格名
		を送る
 -->

 <form method="GET" action="/tasuma/ScheduleServlet" id="Test">
 	<input type="radio" name="selectCertification" value="ITパスポート">
 	<input type="radio" name="selectCertification" value="基本情報技術者試験">
	<input type="submit" name="regist" value="登録">
</form>

</body>
</html>