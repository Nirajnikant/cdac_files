let express = require("express");
let fs = require("fs");

let app = express();


app.get("/", (req,res) => {
    res.sendFile("./js_30.html", {root: __dirname });
});

app.get("/process", (req,res) => {
    let oid = req.query.orderID;
    let cname = req.query.cname;
    let bdate = req.query.billDate;
    let sdate = req.query.shipDate;
    let ttl = req.query.total;
    let datah = oid+"|"+cname+"|"+bdate+"|"+sdate+"|"+ttl;
    //var fs = require('fs'), str = 'string to append to file';
    fs.open('./sample.txt', 'a', 666, function( err, data ) {
        if (err) {
            return console.error(err);
         }
        fs.write(data, "\n"+datah, null, 'utf8', function(){
            fs.close(data, function(){
                console.log('file closed');
            });
        });
    });
    
    //fs.writeFileSync('./sample.txt', datah, 'utf-8');
    res.send("Data has been written to the file");
})

app.listen(3000, () => {
    console.log("App is listening on http://localhost:3000")
});