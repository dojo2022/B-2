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
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<!-- ログインしているユーザ名を右上に表示 -->
	<p class="username">ユーザ名：${username.username}</p>

	<div id="table">

		<h1>TASUMA</h1>
		<!-- タイトル -->

		<h2>My資格</h2>
		<!-- サブタイトル -->

		<!-- カテゴリをプルダウンで表示 -->
		<form method="post">
			<div>
				<label for="select2">カテゴリ</label>
				<!-- カテゴリをプルダウンで表示 -->
				<select name="select">
					<option>選択してください</option>
					<option value="allit">IT知識全般</option>
					<option value="gengo">IT言語</option>
					<option value="data">データベース</option>
					<option value="sec">セキュリティ</option>
					<option value="net">ネットワーク</option>
					<option value="mana">マネジネント</option>
					<option value="jimu">事務作業</option>
					<option value="des">デザイン</option>
				</select>
			</div>
			<!-- カテゴリをプルダウンで表示ここまで -->



			<!-- 資格名をテキスト入力 -->
			<table>
				<tr>
					<th><input type="text" id="certification" name="CERTIFICATION"></th>
				</tr>
			</table>
			<!-- 資格名をテキスト入力ここまで -->

			<table>
				<tr>
					<td colspan="2">
						<!-- 検索ボタンをカテゴリと資格名の横につける --> <a
						href="/tasuma/CertificationListServlet"><input type="submit"
							name="SUBMIT" value="検索"></a>
					</td>
				</tr>
			</table>
		</form>

		<h3>資格一覧</h3>

		<table>
			<!-- 番号と資格名を持ってくる -->
			<c:forEach var="e" items="${cardList}">
				<tr class="data_row">

					<td>${e.number}</td>
					<td>${e.certifications}</td>
					<td><form method="POST"
							action="/tasuma/CertificationListServlet">
							<button type="submit" name="SUBMIT" value="日程を決める"></button>
						</form>
				</tr>
				<!-- 日程を決めるボタンを資格名の横に付ける -->
			</c:forEach>
		</table>

		<!-- カテゴリ検索用のc:foreachをここに書く -->
		<!-- IT知識全般のカテゴリを一覧表示 -->

		<table id="allit">

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
		</table>


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
	<script src="/tasuma/WebContent/JavaScript/certification_list.js"></script>

</body>
</html>