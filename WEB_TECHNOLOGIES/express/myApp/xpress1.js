let express = require("express");
let app = express();
//above two lines are mandatory in exprees apps

app.get("/", function(req, res) {
    let str = "<h1>Welcome to first page </h1>";
    let d1 = new Date();
    str += "Today is " + d1.toString();
    res.send(str);
});

app.get("/admin", (eq, res) => {
    res.send("<h1>Welcome Admin </h1>")
});

app.get("/foo", (req, res) => {
    res.send("<h1>This is foo page</h1>")
});

app.get("/string", (req, res) => {
    let str = "<h2>Hello World</h2>"
    res.send(str)
});

app.get("/array", (req, res) => {
    let arr = ["aaa","bbb","ccc"]
    res.send(arr)
});

app.get("/json", (req, res) => {
    let obj = {name: "shrilata" , email: "nirajnikant@gmail.com"}
    res.send(obj)
});



app.listen(3000, () => {
    console.log("App is listening on http://localhost:3000")
});