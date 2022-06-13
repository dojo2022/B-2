<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>
        TASUMA|ユーザー設定
        <link rel="stylesheet"type="text/css" href="/tasuma/css/user_setting.css">
        </title>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <link rel="stylesheet"type="text/css" href="/tasuma/css/login.css">
        <h1 name="title">TASUMA</h1>
        <h2 name="subtitle">ユーザ設定</h2>
        <h4 name="username">ユーザー名</h4>
        <form method="POST" action="/simpleBC/LoginServlet"  id="login_form">
            <table>
                <tr>
                    <td>ユーザー名</td><td><input type="text" name="username_box"></td>
                </tr>
                <tr>
                    <td>メールアドレス</td><td><input type="text" name="mail_box"></td>
                </tr>
                <tr>
                    <td>PW</td><td><input type="password" name="password_box"></td>
                </tr>
                <tr>
                    <td><input type="checkbox" name="pw_display"></td><td>パスワードを表示</td>
                </tr>
                <tr>
                    <td><input type="button" name="back_menu" value="メニューに戻る"></td>
                    <td><input type="submit" name="change_profile" value="変更"></td>
                </tr>
            </table>
            </form>

        <footer class="footer">
            <p>&copy;Copyright plus DOJO(SE plus). All rights reserved.</p>
          </footer>
        <script>
        'use strict'

        let formObj = document.getElementById('login_form');
        formObj.onsubmit = function(event) {
                window.alert('登録情報を変更しました');
            };

        </script>
        <script src="/tasuma/WebContent/JavaScript/user_setting.js"></script>
</body>
</html>