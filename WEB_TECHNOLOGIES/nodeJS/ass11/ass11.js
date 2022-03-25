//Consider a json object that describes a book with bookid, name, author and price. Convert this json object into string and save into a file book.txt 
var fs = require("fs");

fs.readFile("./book.json", (err,data) => {
    if(err) {
        return console.error(err);
    }
    var obj = JSON.parse(data);

    var bookjson = JSON.stringify(obj);
    fs.writeFileSync("./books.txt", bookjson,'utf-8');
    //console.log(obj);
});