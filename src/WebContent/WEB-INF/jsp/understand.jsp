<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/tasuma/css/understand.css">
<meta charset="UTF-8">
<title>TASUMA|理解度報告</title>
</head>
<body>
<!-- ヘッダーここから -->
	<p class="username">ユーザ名:${username.username }</p>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
<!-- ヘッダーここまで -->
	<h2>理解度報告</h2>

	<c:forEach var="e" items="${understands }">
		<details>
		<summary class="h3">${e.certification }</summary>
		<h4>今日の目標</h4>
		<% int count = 0; %>
		<form action="/tasuma/UnderstandServlet" method="post">
			<table>
				<tr>
					<th>項目名</th>
					<th>目標詳細</th>
					<th>&#x1F613;</th>
					<th>&#x1f610;</th>
					<th>&#x1f60a;</th>
				</tr>
				<c:forEach var="e1" items="${e.ttList }">
					<tr>
						<td>${e1.item_id }</td>
						<td>${e1.target_id }</td>
						<td><input type="radio" name="tu<%=count %>" value="1"
						<c:if test="${e1.target_understand == '1'}">
						checked
						</c:if>></td>
						<td><input type="radio" name="tu<%=count %>" value="2"
						<c:if test="${e1.target_understand == '2'}">
						checked
						</c:if>></td>
						<td><input type="radio" name="tu<%=count %>" value="3"
						<c:if test="${e1.target_understand == '3'}">
						checked
						</c:if>></td>
					</tr>
					<input type="hidden" name="t<%=count %>" value="${e1.target_id }">
					<% count++; %>
				</c:forEach>
			</table>
			<input type="hidden" name="count" value="<%=count%>">
			<input type="hidden" name="certification" value="${e.certification }">
			<input type="submit" class="button" value="報告">
		</form>


		<h4>目標一覧</h4>
			<table>
				<tr>
					<th>項目名</th>
					<th>目標詳細</th>
					<th>最終報告日</th>
					<th>理解度</th>
				</tr>
				<c:forEach var="e2" items="${e.tuList }">
					<tr>
						<td>${e2.item_id }</td>
						<td>${e2.target_id }</td>
						<td>${e2.day }</td>
						<td>
						<c:choose>
							<c:when test="${e2.target_understand == '1'}">
								&#x1F613;
							</c:when>
							<c:when test="${e2.target_understand == '2'}">
								&#x1f610;
							</c:when>
							<c:when test="${e2.target_understand == '3'}">
								&#x1f60a;
							</c:when>
						</c:choose></td>
					</tr>
				</c:forEach>
			</table>
		</details>
	</c:forEach>

	<!-- メニューボタン -->
	<table>
	 <tr class="menu">
		<td><a href="/tasuma/MenuServlet">
			<button type="button" class="button" name="back_menu">メニューに戻る</button>
		</a></td>
	 </tr>
    </table>
	<!-- フッターここから -->
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	<!-- フッターここまで -->
</body>
</html>