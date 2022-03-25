let arr = ["Liam",
    "Olivia",
    "Noah",
    "Emma",
    "Oliver",
    "Ava",
    "William",
    "Sophia",
    "Elijah",
    "Isabella",
    "James",
    "Charlotte",
    "Benjamin",
    "Amelia",
    "Lucas",
    "Mia",
    "Mason",
    "Harper",
    "Ethan",
    "Evelyn"
]

let str = arr.join("|");

var fs = require('fs');

fs.writeFile("names.txt", str , function(err) {
    if(err) {
        return console.log(err);
    }
    console.log("The file was saved!");
}); 