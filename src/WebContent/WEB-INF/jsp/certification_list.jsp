<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<!-- ヘッダー開始 -->
<head>
<meta charset="UTF-8">
<title>TASUMA | 資格一覧</title>
<link rel = "stylesheet" type = "text/css" href = "/tasuma/css/login.css">
</head>

<header><%@ include file="/WebContent/WEB-INF/jsp/header.jsp" %></header>

<!-- ヘッダー終了 -->

<body>

<div id = "table">
<table id = "list">

<!-- 名刺管理アプリで作成した一覧表jspを、
　　　　　　　　とりあえずコピペしたりしています。わからん -->

<h2>My資格</h2> <!-- サブタイトル -->

	<tr>
  		<th>カテゴリ</th><th>資格名</th>
	</tr>

<!-- 検索ボタンをカテゴリと資格名の横につける -->


<h3>資格一覧</h3>

	<c:forEach var="e" items="${cardList}"> <!-- 番号と資格名を持ってくる -->
	<tr class="data_row"><td>${e.number}</td><td>${e.name}</td></tr>
	</c:forEach>

	<tr>
		<td colspan="2">
	    <input type="submit" name="SUBMIT" value="日程を決める">
	</td>  <!-- 日程を決めるボタンを資格名の横に付ける -->


	<tr>
		<td colspan="2">
	    <input type="submit" name="SUBMIT" value="メニューに戻る">
	</td>  <!-- メニューに戻るボタンを左下につける -->


<h4>ユーザ名："${username}"</h4> <!-- 画面右上にログインしているユーザ名を表示 -->

</table>
</div>

<form method="GET" action="certification_list.jsp" id="form">
	<input type="hidden" name="number">
</form>



<footer></footer>

<script src="/tasuma/WebContent/JavaScript/certification_list.js"></script>

</body>
</html>