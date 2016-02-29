var http = require("http");

var PLAYER_ID = "0150835"; // Your given player id
var HOSTNAME = "localhost"; // FTA-Server address
var PORT = 8081; // FTA-server-port


function answerQuestions() {
	var data = [[0,0],[1,0]];
	console.log("Answering " + data);

	var postoptions = {
	  hostname: HOSTNAME,
	  port: PORT,
	  path: '/game/shoot/' + PLAYER_ID,
	  method: 'POST'
	};


	var req = http.request(postoptions, function(res) {
	  console.log('STATUS: ' + res.statusCode);
	  console.log('HEADERS: ' + JSON.stringify(res.headers));
	  res.setEncoding('utf8');
	  res.on('data', function (chunk) {
	    console.log('ANSWERBODY: ' + chunk);
	  });
	});

	req.on('error', function(e) {
	  console.log('problem with request: ' + e.message);
	});

	// write data to request body
	req.write(data);
	req.end();
} 





