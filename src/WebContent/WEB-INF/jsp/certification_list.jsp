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

	<div id="table">

		<h1><jsp:include page="/WEB-INF/jsp/header.jsp" /></h1>
		<!-- タイトル -->

		<h2>My資格</h2>
		<!-- サブタイトル -->

		<!-- カテゴリをプルダウンで表示 -->
		<form method="POST" action="/tasuma/CertificationListServlet">
			<div>
				<label for="select2">カテゴリ</label>
				<!-- カテゴリをプルダウンで表示 -->
				<select id="selector" name="select">
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
			</div>
			<!-- カテゴリをプルダウンで表示ここまで -->



			<!-- 資格名をテキスト入力 -->
			<!-- 	<table>
				<tr>
					<th><input type="text" id="certification" name="CERTIFICATION"></th>
				</tr>
			</table>
			<!-- 資格名をテキスト入力ここまで -->

			<!--  <table>
				<tr>
					<td colspan="2">
				<!--		<!-- 検索ボタンをカテゴリと資格名の横につける -->
			<!-- 		<a href="/tasuma/CertificationListServlet"></a>
						<input type = submit name = submit value= 検索>
					</td>
				</tr>
			</table> -->


			<!-- テキスト検索 -->

			<input type="text" id="certification" name="CERTIFICATION"><br>
			<input id="submit" type="submit" name="REGIST" value="検索"><br>
		</form>



		<h3>資格一覧</h3>



		<!-- カテゴリ検索用のc:foreachをここに書く -->
		<!-- IT知識全般のカテゴリを一覧表示 -->

		<%-- <table id="allit">

			<tr>
				<th>IT知識全般</th>
			</tr>
			<c:forEach var="e" items="${allit}">
				<tr class="data_row">
					<td>${e.certification}</td>
			</c:forEach>

		</table>

		<!-- IT言語系のカテゴリを一覧表示 -->
		<table id="gengo">
			<tr>
				<th>IT言語</th>
			</tr>
			<c:forEach var="e" items="${gengo}">
				<tr class="data_row">
					<td>${e.certification}</td>
			</c:forEach>
		</table>

		<!-- データベース系のカテゴリを一覧表示 -->
		<table id="data">
			<tr>
				<th>データべース</th>
			</tr>
			<c:forEach var="e" items="${data}">
				<tr class="data_row">
					<td>${e.certification}</td>
			</c:forEach>
		</table>

		<!-- セキュリティ系のカテゴリを一覧表示 -->
		<table id="sec">
			<tr>
				<th>セキュリティ</th>
			</tr>
			<c:forEach var="e" items="${sec}">
				<tr class="data_row">
					<td>${e.certification}</td>
			</c:forEach>
		</table>

		<!-- ネットワーク系のカテゴリを一覧表示 -->
		<table id="net">
			<tr>
				<th>ネットワーク</th>
			</tr>
			<c:forEach var="e" items="${net}">
				<tr class="data_row">
					<td>${e.certification}</td>
			</c:forEach>
		</table>

		<!-- マネジメント系のカテゴリを一覧表示 -->
		<table id="mana">
			<tr>
				<th>マネジメント</th>
			</tr>
			<c:forEach var="e" items="${mana}">
				<tr class="data_row">
					<td>${e.certification}</td>
			</c:forEach>
		</table>

		<!-- 事務作業系のカテゴリを一覧表示 -->
		<table id="jimu">
			<tr>
				<th>事務作業</th>
			</tr>
			<c:forEach var="e" items="${jimu}">
				<tr class="data_row">
					<td>${e.certification}</td>
			</c:forEach>
		</table>

		<!-- デザイン系のカテゴリを一覧表示 -->
		<table id="des">
			<tr>
				<th>デザイン</th>
			</tr>
			<c:forEach var="e" items="${des}">
				<tr class="data_row">
					<td>${e.certification}</td>
			</c:forEach>
		</table> --%>

		<!-- カテゴリとテキスト検索 -->
	<!--  	<table>
			<tr>
				<th>${certList[0].category}</th>
			</tr>
			<c:forEach var="e" items="${certList}">
				<tr class="data_row">
					<td>${e.certification}</td>
			</c:forEach>
		</table>
		<!-- カテゴリとテキスト検索ここまで -->


		<!-- 日程を決めるボタンを資格名の横に付ける＋共通ページへ遷移 -->

		<div class="table">
			<table>
			<tr>
			<th>${certList[0].category}</th>
			</tr>
				<c:forEach var = "e" items = "${certList}">
				<tr class ="rowdata">
				<td>${e.certification}</td>
				<td><form method = "POST" action = "/tasuma/ScheduleServlet">
				<button type = "submit" name="certification" value = ${e.certification }>日程を決める</button></form></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<!-- 日程を決めるボタンここまで -->

		<table>
			<tr>
				<td colspan="2"><a href="/tasuma/MenuServlet"><input
						type="button" name="BUTTON" value="メニューに戻る"></a></td>
				<!-- メニューに戻るボタンを左下につける -->
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