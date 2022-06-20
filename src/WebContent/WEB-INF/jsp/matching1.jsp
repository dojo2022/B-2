<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h2>My資格</h2>
<!-- 質問 -->
<p>何に興味がありますか？</p>
<hr>
<form method="POST" action="/tasuma/Matching1Servlet" id="select_category" id="select_category">
	<table>
	 	<tr>
			<td><input type="radio" name="category" id="allit" value="allit"></td><td >IT知識全般</td>
		</tr>
		<tr>
			<td><input type="radio" name="category" id="gengo" value="gengo"></td><td>プログラミング言語</td>
		</tr>
		<tr>
			<td><input type="radio" name="category" id="data" value="data"></td><td>データベース</td>
		</tr>
		<tr>
			<td><input type="radio" name="category" id="sec" value="sec"></td><td>セキュリティ</td>
		</tr>
		<tr>
			<td><input type="radio" name="category" id="net" value="net"></td><td>ネットワーク</td>
		</tr>
		<tr>
			<td><input type="radio" name="category" id="mana" value="mana"></td><td>マネジメント</td>
		</tr>
		<tr>
			<td><input type="radio" name="category" id="jimu" value="jimu"></td><td>事務作業で使用するツール</td>
		</tr>
		<tr>
			<td><input type="radio" name="category" id="des" value="des"></td><td>デザイン</td>
		</tr>
	</table>
	<div class="submit"><input type="submit" name="matching_next" value="次へ"class="next"></div>
</form>
<!-- フッター -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>