<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TASUMA|理解度報告</title>
</head>
<body>
<!-- ヘッダーここから -->
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
<!-- ヘッダーここまで -->
	<p class="username">${username.username }</p>
	<h2>理解度報告</h2>


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
</html>