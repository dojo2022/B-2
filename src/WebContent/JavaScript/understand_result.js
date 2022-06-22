/**
 *
 */
'use strict'
onload = function() {
  draw();
};

function draw() {
  var canvas = document.getElementById('tasuma');
  if ( ! canvas || ! canvas.getContext ) {
    return false;
  }
  var cvs = canvas.getContext('2d');

  /* 設定したcanvasに描画を行う*/
	cvs.beginPath(); /* 図形を描き始めることを宣言 */
	cvs.fillStyle = 'saddlebrown'; //図形の色を指定
    // 円の中心座標: (320,320)
    // 半径: 50
    // 開始角度: 0度 (0 * Math.PI / 180)
    // 終了角度: 360度 (360 * Math.PI / 180)
    cvs.arc( 480, 320, 100, 0 * Math.PI / 180, 360 * Math.PI / 180);

    // 線の太さ
    cvs.lineWidth = 1 ;
    cvs.fill(); //図形を指定した色で塗りつぶす

    //円の真上から左回りに楕円を10個作成
    cvs.beginPath();
	cvs.fillStyle = 'yellow';
    //円の真上の楕円
    cvs.ellipse(480, 130, 90, 45, Math.PI / 2, 0, 2 * Math.PI);
    cvs.fill();

    cvs.beginPath();
	cvs.fillStyle = 'yellow';
    //左上　上側
    cvs.ellipse(380, 160, 90, 45, Math.PI / 3, 0, 2 * Math.PI);
    cvs.fill();

    cvs.beginPath();
	cvs.fillStyle = 'yellow';
    //左上　下側
    cvs.ellipse(310, 240, 90, 45, Math.PI / 6, 0, 2 * Math.PI);
    cvs.fill();

    cvs.beginPath();
	cvs.fillStyle = 'yellow';
    //左下　上側
    cvs.ellipse(310, 400, 90, 45, 5 * Math.PI / 6, 0, 2 * Math.PI);
    cvs.fill();

    cvs.beginPath();
	cvs.fillStyle = 'yellow';
    //左下　下側
    cvs.ellipse(380, 480, 90, 45, 2 * Math.PI / 3, 0, 2 * Math.PI);
    cvs.fill();

    cvs.beginPath();
	cvs.fillStyle = 'yellow';
    //円の真下
    cvs.ellipse(480, 510, 90, 45, Math.PI / 2, 0, 2 * Math.PI);
    cvs.fill();

    cvs.beginPath();
	cvs.fillStyle = 'yellow';
    //右下　下側
    cvs.ellipse(580, 480, 90, 45, Math.PI / 3, 0, 2 * Math.PI);
    cvs.fill();

    cvs.beginPath();
	cvs.fillStyle = 'yellow';
    //右下　上側
    cvs.ellipse(650, 400, 90, 45, Math.PI / 6, 0, 2 * Math.PI);
    cvs.fill();

    cvs.beginPath();
	cvs.fillStyle = 'yellow';
    //右上　下側
    cvs.ellipse(650, 240, 90, 45, 5 * Math.PI / 6, 0, 2 * Math.PI);
    cvs.fill();

    cvs.beginPath();
	cvs.fillStyle = 'yellow';
  //  右上　上側
    cvs.ellipse(580, 160, 90, 45, 2 * Math.PI / 3, 0, 2 * Math.PI);
    cvs.fill();
}