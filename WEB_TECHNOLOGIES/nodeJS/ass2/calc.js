exports.add = function(a,b) {
    console.log("Sum = " + (a+b));
}
exports.subtract = function(a,b) {
    console.log("Substraction = " + (a-b));
}
exports.multiply= function(a,b) {
    console.log("Multiplication = "+a*b);
}
exports.divide = function(a,b) {
    console.log("Division = "+a/b);
}
exports.square = function(a) {
    console.log("Square = " + Math.pow(a,2))
}
exports.sum =(...theArgs) =>{
    console.log(theArgs.reduce((previous, current) => {
      return previous + current;
    }));
}
exports.min = function(a,b,c) {
    console.log("Minimum = "+Math.min(a,b,c));
}
exports.max = function(a,b,c) {
    console.log("Maximum = " + Math.max(a,b,c));
}
