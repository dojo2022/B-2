/**
 *
 */
/**パスワード表示 */
'use strict'
console.log("hello");
 const password = document.getElementById('newPassword');
 const pwdCheck = document.getElementById('pw_display');
 pwdCheck.addEventListener('change', function() {
     if(pwdCheck.checked) {
         password.setAttribute('type', 'text');
     } else {
         password.setAttribute('type', 'password');
     }
 }, false);

/**エラーメッセージ */
var formObj=document.getElementById("registForm");
var username=document.getElementById("newUsername");
/**var password=document.getElementById("newPassword");*/
var errormsg=document.getElementById("error_message")
/**必須項目が無記入だった場合のエラーメッセージ */

formObj.onsubmit=function(){
	if(!usename || !password){
		errormsg.textContent='必須項目入力してください。'
		return false;
	}
/**ユーザ名がすでに使われている場合のエラーメッセージ */
	errormsg=null;
}