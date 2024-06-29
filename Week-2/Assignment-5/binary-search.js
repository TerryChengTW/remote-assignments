function binarySearchPosition(numbers, target) {
    // your code here
    let start = 0;
    let end = numbers.length - 1;
    let mid = Math.floor((start + end) / 2);
    while (start <= end) {
        if (numbers[mid] === target) {
        return mid;
        } else if (numbers[mid] < target) {
        start = mid + 1;
        } else {
        end = mid - 1;
        }
        mid = Math.floor((start + end) / 2);
    }return -1;
}
console.log(binarySearchPosition([1, 2, 5, 6, 7], 1)); // should print 0
console.log(binarySearchPosition([1, 2, 5, 6, 7], 6)); // should print 3
console.log(binarySearchPosition([1, 2, 5, 6, 7], 8));