var now = new Date(Date.now());
console.log("Current date and time: " + now.toString());

var date = now.getDate();
var month = now.getMonth(); // Months are zero-based
var year = now.getFullYear();
var weekDay = now.getDay(); // 0 (Sunday) to 6 (Saturday)

var weekDays = ["Неделя", "Понеделник", "Вторник", "Сряда", "Четвъртък", "Петък", "Събота"];
var monthNames = ["Януари", "Февруари", "Март", "Април", "Май", "Юни", "Юли", "Август", "Септември", "Октомври", "Ноември", "Декември"];
console.log("Днес е: " + date + " " + monthNames[month] + " " + year + ", " + weekDays[weekDay]);