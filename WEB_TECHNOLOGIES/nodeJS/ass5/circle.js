exports.calcArea = r => {
    console.log("Area(ciricle) = "+ (Math.PI*r*r).toFixed(2));
}

exports.calcCircumference = r => {
    console.log("Circumference = " + (2*Math.PI*r).toFixed(2));
}

exports.calcDiameter= r => {
    console.log("Diameter = "+((2*r).toFixed(2)));
}