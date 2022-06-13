/**
 *
 */
var formObj=getElementById("registForm");
var username=getElementById("newUsername");
var password=getElementById("newPassword");
var errormsg=getElementById("error_message")
/**必須項目が無記入だった場合のエラーメッセージ */

formObj.onsubmit=function(){
	if(!usename || !password){
		errormsg.textContent='必須項目入力してください。'
		return false;
	}
/**ユーザ名がすでに使われている場合のエラーメッセージ */
	errormsg=null;
}