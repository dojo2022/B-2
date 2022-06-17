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
<form method="POST" action="/tasuma/Matching1Servlet" id="matching">
	<table>
	 	<tr>
			<td><input type="radio" name="allit" id="allit"></td><td >IT知識全般</td>
		</tr>
		<tr>
			<td><input type="radio" name="gengo" id="gengo"></td><td>プログラミング言語</td>
		</tr>
		<tr>
			<td><input type="radio" name="data" id="data"></td><td>データベース</td>
		</tr>
		<tr>
			<td><input type="radio" name="sec" id="sec"></td><td>セキュリティ</td>
		</tr>
		<tr>
			<td><input type="radio" name="net" id="net"></td><td>ネットワーク</td>
		</tr>
		<tr>
			<td><input type="radio" name="mana" id="mana"></td><td>マネジメント</td>
		</tr>
		<tr>
			<td><input type="radio" name="jimu" id="jimu"></td><td>事務作業で使用するツール</td>
		</tr>
		<tr>
			<td><input type="radio" name="des" id="des"></td><td>デザイン</td>
		</tr>
	</table>
	<div class="submit"><input type="submit" name="matching_next" value="次へ"class="next"></div>
</form>
<!-- フッター -->
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>