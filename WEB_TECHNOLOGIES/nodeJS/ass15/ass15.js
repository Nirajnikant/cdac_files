var http = require('http');
var url = require('url');
var fs = require('fs');
var rectangle = require("./rectangle.js");

function process_req(req, res) {
    if (req.method == 'GET' && req.url == '/') {
        fs.readFile('rect.html', function(err, data) {
            res.writeHead(200, {'Content-Type': 'text/html'});
            res.write(data);
            res.end();
        });
    }
    else if(req.method == 'GET' && req.url.substring(0,8) == '/process'){ //localhost ke url ke baad /process hai substring between 0,8
        var q = url.parse(req.url, true);
        var qdata = q.query;
        var l = qdata.length;   
        var b = qdata.breadth;
        let area = rectangle.calcArea(l,b);
        let perimeter = rectangle.calcPerimeter(l,b);
        res.writeHead(400, {'Content-Type': 'text/plain'});
        res.write("The area is : " + area +"\nThe Perimeter = "+ perimeter);
        res.end();
    }
    else
    res.end("not found");
}
var server = http.createServer(process_req)
server.listen(3000);
console.log('server listening on localhost:3000');