// insert 실행 
var mysql = require('mysql'); 

var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'java85',
  password : '1111',
  database : 'java85db'
});

connection.connect();

// select 질의하기
connection.query(
  'insert into boards(title,conts,cre_dt) values(?,?,now())', 
  ['title...한글', 'content....'], // in-param에 들어갈 값을 배열에 담는다.
  function(err, rows, fields) {
	  if (err) throw err;
	  
	  console.log("입력 성공!");
});


connection.end();
