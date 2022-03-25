
let express = require("express");
let app = express();
let path = require("path");

app.get("/", (req,res) => {
    res.sendFile(path.join(__dirname + "/try1.html"))
});

app.get("/process",(req,res) => {
    var a = parseInt(req.query.num);
    var result="";
    var str = "";
    for(var i=1;i<=10;i++) {
        result += (a*i)+"<br>";
        //str = (str + result);
    }
    //let str2 = ("num is " + a);
    //res.send(str2);
    res.send(result);
});

app.listen(3000,()=>{
    console.log('App is listening on http://localhost:3000');
});