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
	<!--
	マッチングページにリンク飛ぶ「資格登録ボタン」(マッチング)
	資格登録一覧ページリンク飛ぶ「資格登録ボタン」(一覧)
	-->
		<button onclick="location.href='/tasuma/MatchingServlet'">マッチング</button>
		<button onclick="location.href='/tasuma/CertificationListServlet'">一覧から選ぶ</button>

		<h3>My資格一覧</h3>
	<!--
	登録資格一覧(登録済の取得目標資格をリスト形式で表示する)
	登録資格削除ボタン(←を実行すると登録資格一覧からも削除される)
	のテーブル -->

	<!-- ↓に登録された資格が一覧表示される 削除ボタンは横にあるからこの配置？ -->
	<!-- 自信ないです(泣き) -->
		<table class="list">
			<c:forEach var="e" items="${e.cardlist}">
				<tr class="data_row"><td>${e.certification}</td><td><input type="submit" name="regist_delete" value="削除"></td></tr>
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