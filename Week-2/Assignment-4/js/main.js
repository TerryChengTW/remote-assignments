let welcome = true;
let boxVisible = false;

function welcomeMessage() {
    if (welcome) {
        document.getElementById('welcome').innerHTML = 'Have a Good Time!';
    } else {
        document.getElementById('welcome').innerHTML = 'Welcome Message!';
    }
    welcome = !welcome;
}

function boxVisibility() {
    const hiddenBoxes = document.querySelectorAll('.hidden');
    hiddenBoxes.forEach(box => {
        if (boxVisible) {
            box.style.display = 'none';
        } else {
            box.style.display = 'flex';
        }
    });
    boxVisible = !boxVisible;
}

// 為 "Welcome Message" 註冊點擊事件處理程序
document.getElementById('welcome').addEventListener('click', welcomeMessage);

// 為 "Call to Action" 按鈕註冊點擊事件處理程序
document.getElementById('select-cursor').addEventListener('click', boxVisibility);
