/**
 *
 */
/**パスワード表示 */
'use strict'
 const password = document.getElementById('password');
 const pwdCheck = document.getElementById('pw_display');
 pwdCheck.addEventListener('change', function() {
     if(pwdCheck.checked) {
         password.setAttribute('type', 'text');
     } else {
         password.setAttribute('type', 'password');
     }
 } );

var formObj=document.getElementById("loginForm");
var username=document.getElementById("username");
/**var password=getElementById("password");*/
var errormsg=document.getElementById("error_message");

/**ユーザ名が空欄のときのエラーメッセージ */
formObj.onsubmit=function(){
	if(!username || !password){
		errormsg.textContent='ユーザ名を入力してください！';
		return false;
	}
	errormsg=null;
};
