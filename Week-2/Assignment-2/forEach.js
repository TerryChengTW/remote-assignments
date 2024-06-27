// Complete the function below to calculate the average price of all the products.
function avg(data) {
    // your code here
    let sum = 0;
    data.products.forEach(product => {sum += product.price;});
    return sum / data.size;
}
console.log(
    avg({
        size: 3,
        products: [
            {
                name: 'Product 1',
                price: 100,
            },
            {
                name: 'Product 2',
                price: 700,
            },
            {
                name: 'Product 3',
                price: 250,
            },
        ],
    })
); // should print the average price of all products