// 17/11  last
// 18/11  start


//create the Promise
/*let promise = new Promise((resolve, reject) => {
    //executer code - this will take sometime 
    if(condtion) 
        resolve(value)
    else
        reject()
})

//consume the promise

//promise.then(onFulfill, onRject)

//promise.then(omFulfill).catch(onReject)
promise.then(f1,f2)
*/

const promise = new Promise((resolve,reject) => {
    return reject("tatti")
})

promise.catch(err => console.log(err))

promise.then(function(result) {
    console.log
})