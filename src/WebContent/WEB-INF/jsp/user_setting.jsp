<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>TASUMA|ユーザー設定</title>
    <link rel="stylesheet"type="text/css" href="/tasuma/css/user_setting.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <header><jsp:include page="/WEB-INF/jsp/header.jsp"/></header>
        <h1>TASUMA</h1>
        <h2>ユーザ設定</h2>
        <h4>ユーザー名</h4>
        <form method="POST" action="/tasuma/User_SettingServlet" id="user_setting">
            <table>
                <tr>
                    <td>ユーザー名</td><td><input type="text" name="username_box"></td>
                </tr>
                <tr>
                    <td>メールアドレス</td><td><input type="text" name="mail_box"></td>
                </tr>
                <tr>
                    <td>PW</td><td><input type="password" name="password_box" id="password"></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="pw_display" id="pw_display">パスワードを表示</td>
                </tr>
                <tr>
                    <td><input type="button" name="back_menu" value="メニューに戻る"></td>
                    <td><input type="submit" name="change_profile" value="変更"></td>
                </tr>
            </table>
            </form>
            <span id="error_message"></span>
        <script src="/tasuma/WebContent/JavaScript/user_setting.js"></script>
        <footer><jsp:include page="/WEB-INF/jsp/footer.jsp"></footer>
</body>
</html>