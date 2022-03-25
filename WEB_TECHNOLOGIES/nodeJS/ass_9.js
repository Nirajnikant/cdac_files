//save employee object in a text file using same format as in previous assignment

var fs = require("fs");

console.log("going to read file!");
function empdetails(empid,empname,salary) {
    this.empid = empid
    this.empname = empname
    this.salary = salary
}

emp1 = new empdetails(1001,"Michael Scott",230000);
emp2 = new empdetails(1002,"Jim Halpert",23000);
emp3 = new empdetails(1003,"Dwight Schrut",23000);
emp4 = new empdetails(1004,"Stanley Hudson",23000);
var arr=[emp1,emp2,emp3,emp4];



let eid = arr.map(a => a.empid);
let ename = arr.map(a => a.empname);
let sal = arr.map(a => a.salary);
var data ="EmpID:Name:Salary";
for(var i=0;i<eid.length;i++) {
    data = data+"\n"+eid[i]+":"+ename[i]+":"+sal[i];
}
console.log(data)

fs.writeFileSync('./emp1.txt', data, 'utf-8');


