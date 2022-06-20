/**
 *
 */

'use strict';
/*セレクトのエレメント*/
const selector = document.getElementById("selector");

const submit = document.getElementById("submit");

/*allitテーブルのエレメント*/
const allit =document.getElementById("selector");


submit.addEventListener('change',function(){
	console.log(selector.value);
	allit.style.dislay = "none"; /*表示したいときはblock*/


});