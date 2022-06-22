/**
 *
 */

'use strict'

var errorMessageObj = document.getElementById('errormsg');

var threadname = document.getElementById('threadname');

var category = document.getElementById('category');

if (threadname == null || category == null){
	errorMessageObj.innerText = "必須項目を入力してください";
}