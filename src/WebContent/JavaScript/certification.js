/**
 *
 */
/* [削除]ボタンを押したときの処理 */
'use strict'
function deleteConfirm() {
	var result = confirm("削除してよろしいでしょうか？");

	if (result == false) {
		return false;
	}
}