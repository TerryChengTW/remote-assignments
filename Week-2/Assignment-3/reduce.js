// count: return an object which shows the count of each character.
function count(input) {
    // your code here
    return input.reduce((acc, char) => {
        if (acc[char] === undefined) {
            acc[char] = 1;
        } else {
            acc[char]++;
        }
        return acc;
    }, {});
}
let input1 = ["a", "b", "c", "a", "c", "a", "x"];
console.log(count(input1));
// should print {a:3, b:1, c:2, x:1}

// groupByKey: return an object which shows the summed-up value of each key.
function groupByKey(input) {
    // your code here
    return input.reduce((acc, { key, value }) => {
        if (acc[key] === undefined) {
            acc[key] = value;
        } else {
            acc[key] += value;
        }
        return acc;
    }, {});
}
let input2 = [
{ key: "a", value: 3 },
{ key: "b", value: 1 },
{ key: "c", value: 2 },
{ key: "a", value: 3 },
{ key: "c", value: 5 },
];
console.log(groupByKey(input2));
// should print {a:6, b:1, c:7}