function ajax(src, callback) {
    // your code here
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var data = JSON.parse(xhr.responseText); 
            callback(data); 
        }
    };
    xhr.open("GET", src, true); 
    xhr.send(); 
}

function render(data) {
    // your code here
    // document.createElement() and appendChild() methods are preferred.
    var container = document.getElementById('product-container');
    container.innerHTML = ''; 

    data.forEach(function(product) {
        var productElement = document.createElement('div');
        productElement.className = 'product';

        var nameElement = document.createElement('h2');
        nameElement.textContent = product.name;

        var priceElement = document.createElement('p');
        priceElement.textContent = 'Price: ' + product.price;

        var descriptionElement = document.createElement('p');
        descriptionElement.textContent = product.description;

        productElement.appendChild(nameElement);
        productElement.appendChild(priceElement);
        productElement.appendChild(descriptionElement);
        container.appendChild(productElement);
    });
}

ajax( 'https://remote-assignment.s3.ap-northeast-1.amazonaws.com/products', function (response) {
    render(response);
}
); // you should get product information in JSON format and render data in the page

