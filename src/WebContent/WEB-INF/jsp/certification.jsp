<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|My資格</title>
<link rel="stylesheet"type="text/css" href="/tasuma/css/login.css">
</head>
<body>
	<!-- ヘッダーここから -->
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	<!-- ヘッダーここまで -->
	<!-- 画面右上のユーザID ここから これで合ってますか？ -->
		<p class="username">ユーザ名:${username.username}</p>
	<!-- 画面右上のユーザID ここまで -->
		<h2>My資格</h2>

	<!--マッチングページにリンク飛ぶボタン-->
		<!--<div class="button">-->
		  <a href="/tasuma/MatchingServlet">
			<button type="button" name="to_matching">マッチング</button>
		</a>
		<p>...質問チャートを使ってあなたにおすすめの資格をマッチング！</p>
	<!--資格登録一覧ページにリンク飛ぶボタン-->
		<a href="/tasuma/MatchingServlet">
			<button type="button" name="to_list">一覧から選ぶ</button>
		</a>
		<p>...質問チャートを使ってあなたにおすすめの資格をマッチング！</p>
		<!--</div>-->
		<h3>My資格一覧</h3>
	<!--
	登録資格一覧(登録済の取得目標資格をリスト形式で表示する)
	登録資格削除ボタン(←を実行すると登録資格一覧からも削除される)
	のテーブル -->

	<!-- ↓に登録された資格が一覧表示される 削除ボタンは横にあるからこの配置？ -->
	<!-- actionには入力情報を処理するプログラムのURLが必要 -->
	<!-- forEachの中にformを入れると△の注意マークが出てくる-->>
		<table class="list">
			<c:forEach var="e" items="${e.cardlist}">
				<form action="/tasuma/CertificationServlet" method="post" name="list" id="list">
					<tr class="data_row"><td>${e.certification}</td><td><input type="submit" name="regist_delete" value="削除"></td></tr>
				</form>
			</c:forEach>
		</table>
	<!-- メニューボタン -->
		<button onclick="location.href='/tasuma/MenuServlet'">メニューに戻る</button>
		<!-- <a href="/tasuma/MenuServlet">メニューに戻る</a> -->

	<!-- フッターここから -->
		<jsp:include page="/WEB-INF/jsp/footer.jsp" />
	<!-- フッターここまで -->
</body>
<script src="/tasuma/WebContent/JavaScript/login.js"></script>
</html>