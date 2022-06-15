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
setting = request.getAttribute("result_setting"); {
	if (setting = "更新成功！")	{
		window.alert('登録情報を変更しました');
	} else if (setting = "更新失敗！"){
		window.alert('更新に失敗しました');
	}
}