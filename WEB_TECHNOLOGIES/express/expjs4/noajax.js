let express  = require("express");

var app = express();
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended:false}));


app.get("/", (req,res) => {
    res.sendFile("./noajax.html", {root: __dirname });
});

app.post("/", (req,res) => {
    var number = req.body.num;
    res.send("number");
});

app.listen(3000,()=>{
    console.log('App is listening on http://localhost:3000');
});