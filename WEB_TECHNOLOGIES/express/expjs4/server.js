//server.js

var express = require('express');
var app = express();
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({ extended:false}));

//configuring the body-parser middleware
//app.use(bodyParser.json());
//app.use(bodyParser.urlencoded({ extended: true }));


//app.use(express.json());
//app.use(express.urlencoded({ extended: true }));
//setting our app port
//app.set('port', process.env.PORT || 3000);

//Route for  get requests.
app.get('/',(req,res)=>{
    res.sendFile('./expjs.html', {root: __dirname })
});

//Route to handle POST form requests.
app.post('/',(req,res)=>{
    var user_id = req.body.pswd;
    console.log(user_id);
    //we check if the request is an AJAX one and if accepts JSON
    if(req.xhr) {
        res.send({message:'Just wanted to tell you. It worked'})
    } 
    else {
        //Do something else by reloading the page.
    }
});

app.listen(3000,()=>{
    console.log('App is listening on http://localhost:3000');
});