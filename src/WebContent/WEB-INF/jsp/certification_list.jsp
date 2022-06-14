<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>TASUMA | 資格一覧</title>
<link rel = "stylesheet" type = "text/css" href = "/tasuma/css/certification_list.css">
</head>

<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<!-- ログインしているユーザ名を右上に表示 -->
<p class = "username">ユーザ名：${username.username}</p>

<div id = "table">

<h1>TASUMA</h1> <!-- タイトル -->

<h2>My資格</h2> <!-- サブタイトル -->

<!-- カテゴリをプルダウンで表示 -->
<form method = "post">
	<div>
  			<label for ="select">カテゴリ</label><!-- カテゴリをプルダウンで表示 -->
  			<select name = "select">
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
</form>
<!-- カテゴリをプルダウンで表示ここまで -->

<!-- 資格名をテキスト入力 -->
<table>
	<tr>
  		<th><input type="text" id="certification" name="CERTIFICATION"></th>
	</tr>
</table>
<!-- 資格名をテキスト入力ここまで -->

<table>
	<td colspan="2">
	<!-- 検索ボタンをカテゴリと資格名の横につける -->
	<a href="/tasuma/CertificationListServlet"><input type="submit" name="SUBMIT" value="検索"></a>
	</td>
</table>


<h3>資格一覧</h3>

<table>
	<c:forEach var="e" items="${cardList}"> <!-- 番号と資格名を持ってくる -->
	<tr class="data_row">
	<td>${e.number}</td><td>${e.name}</td>
	<td><form method = "POST" action="/tasuma/CertificationListServlet"><button type ="submit" name="NUMBER" value=${e.number}></button></form>
	</tr> <!-- 日程を決めるボタンを資格名の横に付ける -->
	</c:forEach>  <!-- ${}内の名前は仮 -->


	<tr>
		<td colspan="2">
	    <a href="/tasuma/MenuServlet"><input type="button" name="BUTTON" value="メニューに戻る"></a>
		</td>  <!-- メニューに戻るボタンを左下につける -->
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
<jsp:include page="/WEB-INF/jsp/footer.jsp"/>

<!-- javascript -->
<script src="/tasuma/WebContent/JavaScript/certification_list.js"></script>

</body>
</html>