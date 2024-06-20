function countAandB(input) {
    let count = 0;
    for (let char of input) {
        if (char === 'a' || char === 'b') {
            count++;
        }
    }
    return count;
}

function toNumber(input) {
    const letterToNumber = {
        'a': 1,
        'b': 2,
        'c': 3,
        'd': 4,
        'e': 5
    };

    let result = [];
    for (let char of input) {
        result.push(letterToNumber[char]);
    }
    return result;
}

// let input1 = ['a', 'b', 'c', 'a', 'c', 'a', 'c'];
// console.log(countAandB(input1)); 
// should print 4 (3 ‘a’ letters and 1 ‘b’ letter)
// console.log(toNumber(input1)); 
// should print [1, 2, 3, 1, 3, 1, 3]

// let input2 = ['e', 'd', 'c', 'd', 'e'];
// console.log(countAandB(input2)); 
// should print 0
// console.log(toNumber(input2)); 
// should print [5, 4, 3, 4, 5]

// In both questions, you will only get ‘a’, ‘b’, ‘c’, ‘d’, or ‘e’ in the input array.