let http = require("http")  //include hhtp in js file

function handleReq() {
    console.log("req has com in ")
}

let server = http.createServer(handleReq); // created a server object
server.listen(3000, "localhost");