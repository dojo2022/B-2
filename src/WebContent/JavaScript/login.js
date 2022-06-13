/**
 *
 */
var formObj=getElementById("loginForm");
var username=getElementById("username");
var password=getElementById("password");
var errormsg=getElementById("error_message");

/**ユーザ名が空欄のときのエラーメッセージ */
formObj.onsubmit=function(){
	if(!username){
		errormsg.textContent='ユーザ名を入力してください！';
		return false;
	}
	/**パスワードが空欄のときのエラーメッセージ */
	else if(!password){
		errormsg.textContent='パスワードを入力してください！';
		return false;
	}
	/**ユーザ名とパスワードが合致しなかった場合のエラーメッセージ*/
	errormsg=null;
};