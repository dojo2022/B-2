<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|理解度報告</title>
</head>
<body>
<!-- ヘッダーここから -->
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
<!-- ヘッダーここまで -->
	<p class="username">${username.username }</p>
	<h2>理解度報告</h2>

	<c:forEach var="e" items="${understands }">
		<h3>${e.certification }</h3>
		<h4>今日の目標</h4>
		<form>
			<table>
				<c:forEach var="e1" items="${e.ttList }">
					<tr>
						<td>${e1.item_id }</td>
						<td>${e1.target_id }</td>
					</tr>
				</c:forEach>
			</table>
		</form>


		<h4>目標一覧</h4>
			<table>
				<c:forEach var="e2" items="${e.tuList }">
					<tr>
						<td>${e2.item_id }</td>
						<td>${e2.target_id }</td>
						<td>${e2.day }</td>
						<td>${e2.target_understand }</td>
					</tr>
				</c:forEach>
			</table>
	</c:forEach>

	<!-- メニューボタン -->
	<table>
	 <tr class="menu">
		<td><a href="/tasuma/MenuServlet">
			<button type="button" name="back_menu">メニューに戻る</button>
		</a></td>
	 </tr>
    </table>
	<!-- フッターここから -->
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	<!-- フッターここまで -->
</body>
</html>