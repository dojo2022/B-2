<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>TASUMA | 資格一覧</title>
<link rel="stylesheet" type="text/css"
	href="/tasuma/css/certification_list.css">
<!-- <link rel = "stylesheet"type = "text/css" href = "/tasuma/css/style.css"> -->
<script src="./JavaScript/certification_list.js" defer></script>
</head>

<body>

	<!-- ログインしているユーザ名を右上に表示 -->
	<p class="username">ユーザ名：${username.username}</p>

	<div>

		<h1><jsp:include page="/WEB-INF/jsp/header.jsp" /></h1>
		<!-- タイトル -->

		<h2>My資格</h2>
		<!-- サブタイトル -->

		<!-- カテゴリをプルダウンで表示 -->
		<form method="POST" action="/tasuma/CertificationListServlet">
			<div class="same">
				<label for="select2">カテゴリ</label>
				<!-- カテゴリをプルダウンで表示 -->
				<select name="select">
					<option value="">選択してください</option>
					<option value="IT知識全般">IT知識全般</option>
					<option value="IT言語">IT言語</option>
					<option value="データベース">データベース</option>
					<option value="セキュリティ">セキュリティ</option>
					<option value="ネットワーク">ネットワーク</option>
					<option value="マネジメント">マネジネント</option>
					<option value="事務作業">事務作業</option>
					<option value="デザイン">デザイン</option>
				</select>

				<!-- カテゴリをプルダウンで表示ここまで -->


				<!-- テキスト検索 -->

				<input type="text" id="certification" name="CERTIFICATION"><br>

				<!-- 検索ボタン -->
				<input id="submit" type="submit" name="REGIST" value="検索"><br>
			</div>
		</form>



		<h3>資格一覧</h3>

		<!-- 日程を決めるボタンを資格名の横に付ける＋共通ページへ遷移 -->
		<!-- 資格の一覧が表示される＆検索で絞り込みされたものが表示 -->

	<h4>${certList[0].category}</h4>
		<div class="table">
			<table id="list">
				<c:forEach var="e" items="${certList}">
					<tr class="rowdata">
					 	<%-- <c:if test="${${empty ${e.certification}}}"> --%>
					 	<%-- <c:if test="${${e.certification} != ''}"> --%>
						<td><c:out value="${e.certification}"/></td>
						  <%-- </c:if> --%>
						<td><form method="GET" action="/tasuma/ScheduleServlet">
								<button type="submit" name="selectCertification"
									value=${e.certification }>日程を決める</button>
							</form></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<!-- 日程を決めるボタンここまで -->

		<!-- メニューに戻るボタン -->
		<table class ="menu">
			<tr>
				<td><a href="/tasuma/MenuServlet">
						<button type="button" name="menu">メニューに戻る</button>
				</a></td>
			</tr>
		</table>
	</div>


	<!-- これは名刺管理アプリで一覧を作成した際に使用していたコードを、
 一応コピペをして入れてみただけのものです。必要なのでしょうか？ -->
	<form method="GET" action="certification_list.jsp" id="form">
		<input type="hidden" name="number">
	</form>
	<!-- ここまで -->


	<!-- フッター -->
	<jsp:include page="/WEB-INF/jsp/footer.jsp" />

	<!-- javascript -->
	<!-- <script src="/tasuma/WebContent/JavaScript/certification_list.js"></script>
 -->
</body>
</html>