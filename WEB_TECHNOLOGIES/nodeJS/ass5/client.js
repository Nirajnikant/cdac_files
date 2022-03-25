var circle = require('./circle.js');
var rectangle = require('./rectangle.js');
var triangle = require('./triangle.js');

circle.calcArea(7);
circle.calcCircumference(7);
circle.calcDiameter(7);

rectangle.calcArea(5,2);
rectangle.calcPerimeter(5,2);

triangle.isEquilateral(3,4,5);
triangle.calcPerimeter(4,2,3);