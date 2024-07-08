// callback
function delayedResult(n1, n2, delayTime, callback) { 
    // your code here
    setTimeout(() => {
        callback(n1 + n2);
    
    }, delayTime);
}
delayedResult(4, 5, 3000, function (result) {
    console.log("callback: " + result);
}); // 9 (4+5) will be shown in the console after 3 seconds
delayedResult(-5, 10, 2000, function (result) { 
    console.log("callback: " + result);
}); // 5 (-5+10) will be shown in the console after 2 seconds


// promise
function delayedResultPromise(n1, n2, delayTime) { 
    // your code here
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve(n1 + n2);
        }, delayTime);
    });
}
delayedResultPromise(4, 5, 3000).then(result => {
    console.log("'promise': " + result);
});
// 9 (4+5) will be shown in the console after 3 seconds



// await
async function main() {
        // your code here, you should call delayedResultPromise here and get the result using async/await.
        result1 = await delayedResultPromise(4, 5, 3000);
        result2 = await delayedResultPromise(-5, 10, 3000);
        console.log("'await': " + result1);
        console.log("'await': " + result2);
    }
    main(); // result will be shown in the console after <delayTime> seconds