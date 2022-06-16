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

/**更新完了・失敗のアラート表示 */
window.onload=function(){
	let message = document.getElementById('resultmessage').value;
	if(message != ""){
		window.alert(message);
	}
}