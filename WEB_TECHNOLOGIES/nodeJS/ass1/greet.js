exports.read = function() {
    let d =  new Date();
    let h = d.getHours();
    if(h>=5 && h<12)
        console.log("Good Morning");
    if(h>=12 && h<18)
        console.log("Good Afternoon");
    if(h>=18 && h<21)
        console.log("Good Evening");
    if(h>=21)
        console.log("Good Night");
}