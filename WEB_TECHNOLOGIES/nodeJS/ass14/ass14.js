var http = require('http');
var greet = require("./greet.js");

//create a server object:
http.createServer(function (req, res) {
    data = greet.read();
    res.write(data); //write a response to the client
    res.end(); //end the response
}).listen(8080);