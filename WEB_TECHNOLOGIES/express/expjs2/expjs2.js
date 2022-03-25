let express = require("express");
let app = express();

app.get("/", (req,res) => {
    res.sendFile('./expjs2.html', {root: __dirname });
});

app.get("/process", (req,res) => {
    let p = req.query.principle;
    let t = req.query.period;
    let r = req.query.rate;
    let si = (p*t*r/100).toFixed(2);
    res.send("Simple Interset = "+si );

});

app.listen(3000, () => {
    console.log("App is listening on http://localhost:3000")
});