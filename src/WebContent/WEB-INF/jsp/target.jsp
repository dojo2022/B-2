<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|目標設定</title>
<link rel="stylesheet"type="text/css" href="/tasuma/css/target.css">
<!-- <link rel="stylesheet"type="text/css" href="/tasuma/css/style.css"> -->
</head>
<body>
	<!-- ヘッダーここから -->
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<!-- ヘッダーここまで -->
	<!-- 画面右上のユーザID ここから -->
		<p class="username">ユーザ名:${username.username}</p>
	<!-- 画面右上のユーザID ここまで -->
	<h2>目標設定</h2>
	<h3>資格の目標一覧</h3>
	<!-- 各資格における目標一覧（達成済みは除く）をリスト形式で表示する -->
	<!-- 資格目標の右隣に重み(％)とチェックボックスをつける -->
	<!-- 折り畳みボタンを使って表示/非表示を切り替える -->
	<details>
	<summary>資格の目標一覧を表示する</summary>
		<ul>
			<li><label>折りたたむ内容<input type ="checkbox"></label></li>
			<li>折りたたむ内容</li>
			<li>折りたたむ内容</li>
		</ul>
	</details>

	<div class="target">
		<input type="submit" name="target_setting" value="更新">
	</div>

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
<script src="/tasuma/WebContent/JavaScript/target.js"></script>
</html>