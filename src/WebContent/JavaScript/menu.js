'use strict';

document.querySelector('.menu-btn').addEventListener('click', function(){
    document.querySelector('.menu').classList.toggle('is-active');
});

//試験日程から現在日時を引いて表示させる
//カレンダーも？