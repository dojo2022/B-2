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

<div id = "table">

<h1>TASUMA</h1>

<h2>My資格</h2> <!-- サブタイトル -->

<table id = "list">
	<tr>
  		<th><select name="select"> <!-- カテゴリをプルダウンで表示 -->
  			<option value="allit">IT知識全般</option>
  			<option value="gengo">IT言語</option>
  			<option value="data">データベース</option>
  			<option value="sec">セキュリティ</option>
  			<option value="net">ネットワーク</option>
  			<option value="mana">マネジネント</option>
  			<option value="jimu">事務作業</option>
  			<option value="des">デザイン</option>
  			</select>
  		</th>

  		<!-- 資格名をテキスト入力 -->
  		<th><input type="text" id="certification" name="CERTIFICATION"></th>
	</tr>
</table>

	<!-- 検索ボタンをカテゴリと資格名の横につける -->
	<input type="submit" name="SUBMIT" value="検索">


<h3>資格一覧</h3>

<table>
	<c:forEach var="e" items="${cardList}"> <!-- 番号と資格名を持ってくる -->
	<tr class="data_row"><td>${e.number}</td><td>${e.name}</td></tr>
	</c:forEach>  <!-- ${}内の名前は仮 -->

	<tr>
		<td colspan="2">
	    <a href="/tasuma/schedule.jsp"><input type="submit" name="SUBMIT" value="日程を決める"></a>
		</td>  <!-- 日程を決めるボタンを資格名の横に付ける -->
	</tr>


	<tr>
		<td colspan="2">
	    <a href="/tasuma/MenuServlet"><input type="button" name="BUTTON" value="メニューに戻る"></a>
		</td>  <!-- メニューに戻るボタンを左下につける -->
	</tr>
</table>

<h4>ユーザ名："${username}"</h4>
<!-- 画面右上にログインしているユーザ名を表示 -->


</div>

<!-- 74～76 これはなんか入れただけ -->
<form method="GET" action="certification_list.jsp" id="form">
	<input type="hidden" name="number">
</form>


<jsp:include page="/WEB-INF/jsp/footer.jsp"/>


<script src="/tasuma/WebContent/JavaScript/certification_list.js"></script>

</body>
</html>