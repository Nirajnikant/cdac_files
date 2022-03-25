exports.read = function() {
    let d =  new Date();
    let h = d.getHours();
    if(h>=5 && h<12)
        return "Good Morning";
    if(h>=12 && h<18)
        return "Good Afternoon";
    if(h>=18 && h<21)
        return "Good Evening";
    if(h>=21)
        return "Good Night";
}