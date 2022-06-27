<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|目標設定</title>
<link rel="stylesheet"type="text/css" href="/tasuma/css/target.css">
<!-- <link rel="stylesheet"type="text/css" href="/tasuma/css/style.css"> -->
</head>
<body>
	<!-- 画面右上のユーザID ここから -->
		<p class="username">ユーザ名:${username.username}</p>
	<!-- 画面右上のユーザID ここまで -->
	<!-- ヘッダーここから -->
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<!-- ヘッダーここまで -->
	<h2>目標設定</h2>
	<h3>資格の目標一覧</h3>
	<!-- 各資格における目標一覧（達成済みは除く）をリスト形式で表示する -->
	<!-- 資格目標の右隣に重み(％)とチェックボックスをつける -->
	<!-- 折り畳みボタンを使って表示/非表示を切り替える -->

	<% int count = 0; %>
		<form action="/tasuma/TargetServlet" method="post" id="list">
			<c:forEach var="ee" items="${data}">
				<details>
				<summary>${ee.certification}</summary>
					<table class="list">
						<c:forEach var="e" items="${ee.ttList}" varStatus="status">
							<tr><td>${e.item_id}</td>
								<td><input type="checkbox" name="check<%= count %>" value="1"
								<c:if test="${ee.ttList.get(status.index).today_target == '1'}">
								checked
								</c:if>></td></tr>
								<input type="hidden" name="item<%= count %>" value="${e.item_id}">
								<input type="hidden" name="cer<%= count %>" value="${ee.certification}">
						<% count++; %>
						</c:forEach>
					</table>
				</details>
			</c:forEach>

				 <input type="hidden" name="count" value="<%= count %>">
			<div><input type="submit" name="update" value="更新" onclick="return itemsubmit()"></div>
		</form>


	<!-- メニューボタン -->
  	<table class="menu">
		<tr>
			<td><a href="/tasuma/MenuServlet">
				<button type="button" name="back_menu">メニューに戻る</button>
			</a></td>
	 	</tr>
    </table>
	<!-- フッターここから -->
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	<!-- フッターここまで -->
</body>
<script src="JavaScript/target.js"></script>
</html>