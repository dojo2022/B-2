
/* 竹田追記※未完成 ハンバーガーメニューここから */
/* document.querySelector('.menu-btn').addEventListener('click', function(){
document.querySelector('.menu').classList.toggle('is-active');
}); */
/* ハンバーガーメニューここまで */

const weeks = ['日', '月', '火', '水', '木', '金', '土']
const date = new Date()
let year = date.getFullYear()
let month = date.getMonth() + 1

//スコープデータ取得のテスト用
const count = document.getElementById("count").value
var cArray = new Array(count);
var tArray = new Array(count);

for(let i = 0; i < count; i++){
	cArray[i] = document.getElementById("cer"+i).value
	tArray[i] = document.getElementById("test"+i).value
}

for(let i = 0; i < count; i++){
	console.log(cArray[i])
	console.log(tArray[i])
}


function showCalendar(year, month) {
    const calendarHtml = createCalendar(year, month)
    const sec = document.createElement('section')
    sec.innerHTML = calendarHtml
    document.querySelector('#calendar').appendChild(sec)
}

function createCalendar(year, month) {
    const startDate = new Date(year, month - 1, 1) // 月の最初の日を取得
    const endDate = new Date(year, month,  0) // 月の最後の日を取得
    const endDayCount = endDate.getDate() // 月の末日
    const lastMonthEndDate = new Date(year, month - 2, 0) // 前月の最後の日の情報
    const lastMonthendDayCount = lastMonthEndDate.getDate() // 前月の末日
    const startDay = startDate.getDay() // 月の最初の日の曜日を取得
    let dayCount = 1 // 日にちのカウント
    let calendarHtml = '' // HTMLを組み立てる変数

    calendarHtml += '<h1>' + year  + '/' + month + '</h1>'
    calendarHtml += '<table class="table_calendar">'

    // 曜日の行を作成
    for (let i = 0; i < weeks.length; i++) {
        calendarHtml += '<td>' + weeks[i] + '</td>'
    }

    for (let w = 0; w < 6; w++) {
        calendarHtml += '<tr>'

        loop: for (let d = 0; d < 7; d++) {
            if (w == 0 && d < startDay) {
                // 1行目で1日の曜日の前
                let num = lastMonthendDayCount - startDay + d + 1
                calendarHtml += '<td class="is-disabled">' + num + '</td>'
            } else if (dayCount > endDayCount) {
                // 末尾の日数を超えた
                let num = dayCount - endDayCount
                calendarHtml += '<td class="is-disabled">' + num + '</td>'
                dayCount++
            } else {
            	const daytext = year + '/' + month + '/' + dayCount
    	        for(let i = 0; i < count; i++){
        			if(tArray[i] === daytext){
        				console.log('test')
        				calendarHtml += `<td class="calendar_td" id="check" data-date="${year}/${month}/${dayCount}">${dayCount}</td>`
						dayCount++;
        				continue loop;
        			}
        		}
                calendarHtml += `<td class="calendar_td" data-date="${year}/${month}/${dayCount}">${dayCount}</td>`
                dayCount++
            }
        }
        calendarHtml += '</tr>'
    }
    calendarHtml += '</table>'

    return calendarHtml
}

function moveCalendar(e) {
    document.querySelector('#calendar').innerHTML = ''

    if (e.target.id === 'prev') {
        month--

        if (month < 1) {
            year--
            month = 12
        }
    }

    if (e.target.id === 'next') {
        month++

        if (month > 12) {
            year++
            month = 1
        }
    }

    showCalendar(year, month)
}

document.querySelector('#prev').addEventListener('click', moveCalendar)
document.querySelector('#next').addEventListener('click', moveCalendar)

document.addEventListener("click", function(e) {
    if(e.target.classList.contains("calendar_td")) {
        for(let i = 0; i < count; i++){
        	if(e.target.dataset.date === tArray[i]){
        		alert(cArray[i] + 'の試験日です！')
        	}
        }
    }
})


document.querySelector('.menu-btn').addEventListener('click', function(){
    document.querySelector('.menu').classList.toggle('is-active');
});

showCalendar(year, month)