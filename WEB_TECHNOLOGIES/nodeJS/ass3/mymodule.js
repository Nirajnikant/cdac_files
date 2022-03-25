exports.factorial = a => {
    if(a==1)
        return 1;
    else
        return a*this.factorial(a-1);
}

exports.myprime = a => {
    var i,m=0,flag=0;      
    m=a/2;      
    if(a==0||a==1){  
        return (a+" is not prime number");      
    }
    else{  
        for(i=2;i<=m;i++){      
            if(a%i==0){      
                return (a+" is not a prime number");      
                flag=1;      
                break;      
            }      
        }      
        if(flag==0)  { System.out.println(a+" is prime number"); }  
    }
}
exports.printtable = a => {
    var arr = [];
    for(var i=1;i<=10;i++) {
        arr[i] = a + " times " + i + " = " +a*i;
        console.log(arr[i]);
    }
}