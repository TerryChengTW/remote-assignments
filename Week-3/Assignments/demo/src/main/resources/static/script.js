let xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
        let ans = xhr.responseText;
        document.getElementById("result").innerHTML = ans;
    }
};
xhr.open("GET","http://localhost:3000/data?number=10", true);
xhr.send();


document.getElementById("submit").addEventListener("click", function() {
    let num = document.getElementById("numberInput").value;
    let xhr1 = new XMLHttpRequest();
    xhr1.onreadystatechange = function() {
        if (xhr1.readyState ===4 && xhr1.status === 200) {
            let ans1 = xhr1.responseText;
            document.getElementById("result2").innerHTML = ans1;
        }
    };
    xhr1.open("GET","http://localhost:3000/data?number=" +num, true);
    xhr1.send();
});