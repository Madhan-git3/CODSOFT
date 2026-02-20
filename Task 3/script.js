const display = document.getElementById('display');
const buttons = document.querySelectorAll('.btn');

let currentString = '';

buttons.forEach(button => {
    button.addEventListener('click', (e) => {
        const value = e.target.getAttribute('data-value');

        if (value === '=') {
            if (currentString !== '') {
                try {
                    currentString = eval(currentString).toString();
                    display.value = currentString;
                } catch (error) {
                    display.value = 'Error';
                    currentString = '';
                }
            }
        } else if (value === 'AC') {
            currentString = '';
            display.value = '';
        } else if (value === 'DEL') {
            currentString = currentString.slice(0, -1);
            display.value = currentString;
        } else {
            currentString += value;
            display.value = currentString;
        }
    });
});