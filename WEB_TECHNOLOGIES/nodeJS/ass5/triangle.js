exports.isEquilateral = (a,b,c) => {
    if(a==b==c)
        console.log("Triangle is an Equilateral triangle");
    else
        console.log("Triangle is NOT an Equilateral triangle")
}

exports.calcPerimeter = (a,b,c) => {
    console.log("Perimeter(triangle) = "+(a+b+c));
}