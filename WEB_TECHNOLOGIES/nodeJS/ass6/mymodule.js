exports.isPalindrome = (str) => {
    const arrValue = str.split (''); //   
  
    const reveArrVal = arrValue.reverse();       
  
    const revString = reveArrVal.join('');  
    
    if (str == revString) {  
        console.log("It is a Palindrome string"); 
    }  
    else {  
        console.log("It is not a Palindrome string"); 
    }  
}

exports.upper = str => {
    console.log(str.toUpperCase());
}

exports.search = (arr) => {
    var srch = arr.filter((e) => /.*www.*/.test(e));
    console.log(srch.length);
}