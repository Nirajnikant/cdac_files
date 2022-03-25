let express = require("express");
let app = express();

app.get("/", (req, res ) => {
    res.sendFile('./expjs1.html', {root: __dirname })
});

app.get("/process",function (req, res) {
    let a = req.query.first;
    let b = req.query.second;
    let c = req.query.third;
    let arr = [a,b,c];
    let str = "The parameters are <ol>"
    for(var i=0;i<arr.length;i++){
        str +="<li>"+arr[i]+"</li>";
    }
    str +="</ol>"
    console.log(arr);
    res.send(str);
});

app.listen(3000, () => {
    console.log("App is listening on http://localhost:3000")
});