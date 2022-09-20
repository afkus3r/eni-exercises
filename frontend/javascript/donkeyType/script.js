const textArea = document.querySelector("textarea");
const speed = document.querySelector(".speed");
const average = document.querySelector(".average");
let timing = 5000;
let charCount = 0;
let currentSpeed = 0;
let averageSpeed = 0;

textArea.addEventListener("focus", () => {
    do {
        if (charCount === 0) {
            setTimeout(() => {
                currentSpeed = calculateSpeed(calculateChar(), timing);
                speed.appendChild(currentSpeed.cloneNode());
                average.appendChild(currentSpeed.cloneNode());
                charCount = calculateChar();
            }, timing);
        } else {
            setTimeout(() => {
                let newCharNum = calculateChar() - charCount;
                currentSpeed = calculateSpeed(newCharNum, timing);
                averageSpeed = average.firstChild + currentSpeed / 2;
                speed.appendChild(currentSpeed.cloneNode());
                average.appendChild(averageSpeed.cloneNode());
                charCount = calculateChar();
            }, timing);
        }
    } while (charCount < 1000);
})

function calculateChar(text) {
    return text.split("").length;
}

function calculateSpeed(charNumber, milliseconds) {
    return charNumber * 60000 / milliseconds;
}