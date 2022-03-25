//Assume a file customer.json that has customer details like customer name, address, ph no, creditrating etc. Read this file, parse the json and display all customer names along with their contact details


var fs = require('fs');
var obj;
fs.readFile('./ass10/customer.json', 'utf8', function (err, data) {
    if(err){
        return console.error(err);
    }
    obj = JSON.parse(data);
    console.log(obj);
    
    //let cname =  obj.map(a => a.firstName);
    let info = "";
    
    for(e in obj.users) {
        var cdata=obj.users[e];
        console.log(cdata.firstName +" "+cdata.lastName + "\nPhone no. : "+cdata.phoneNumber+"\nEmail-id : "+cdata.emailAddress+"\n" );
    };
    
});