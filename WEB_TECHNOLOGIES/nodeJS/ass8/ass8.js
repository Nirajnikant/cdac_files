var fs = require("fs");
console.log("Going to read file!");

let totalSalary = 0;
fs.readFile('./emp.txt', function(err, data){
    if(err){
        return console.error(err);
    }
    const dataRows = data.toString().split("\n");

    for (let index=0;  index < dataRows.length; index++){
      if (index > 0){
        let empData = dataRows[index].split(":");
        //console.log(empData);
        totalSalary += parseInt(empData[3]);
      }
    }

    console.log(totalSalary);

    console.log("read Successfully");
})

