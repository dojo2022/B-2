<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|My資格</title>
<link rel="stylesheet"type="text/css" href="/tasuma/css/certification.css">
<!-- <link rel="stylesheet"type="text/css" href="/tasuma/css/style.css"> -->
</head>
<body>
	<!-- ヘッダーここから -->
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<!-- ヘッダーここまで -->
	<!-- 画面右上のユーザID ここから -->
		<p class="username">ユーザ名:${username.username}</p>
	<!-- 画面右上のユーザID ここまで -->
		<h2>My資格</h2>

	<!--マッチングページにリンク飛ぶボタン-->
	<div class="button">
		  <a href="/tasuma/Matching1Servlet">
				<button type="button" name="to_matching">マッチング</button></a>

	<!--資格登録一覧ページにリンク飛ぶボタン-->
		  <a href="/tasuma/CertificationListServlet">
				<button type="button" name="to_list">一覧から選ぶ</button></a>

	</div>

	<div class="text">
	  	 <p>...質問チャートを使って資格をマッチング！
		    ...取りたい資格が決まっているあなたはこちら！</p>
	</div>
		<h3>My資格一覧</h3>
	<!--
	登録資格一覧(登録済の取得目標資格をリスト形式で表示する)
	登録資格削除ボタン(←を実行すると登録資格一覧からも削除される)
	のテーブル -->

	<!-- ↓に登録された資格が一覧表示される 削除ボタンは横にあるからこの配置？ -->
	<!-- actionには入力情報を処理するプログラムのURLが必要 -->

			<c:forEach var="e" items="${certification}">
				<form action="/tasuma/CertificationServlet" method="post" id="list">
					<table class="list">
						<tr>
							<td>${e.certification}</td>
							<td><input type="submit" name="regist_delete" value="削除" onclick="return deleteConfirm()"></td>
						</tr>
					</table>
				</form>
			</c:forEach>

	<!-- メニューボタン -->
	<table>
	 <tr class="menu">
		<td><a href="/tasuma/MenuServlet">
			<button type="button" name="back_menu">メニューに戻る</button>
		</a></td>
	 </tr>
    </table>
	<!-- フッターここから -->
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	<!-- フッターここまで -->
</body>
<script src="/tasuma/WebContent/JavaScript/certification.js"></script>
</html>