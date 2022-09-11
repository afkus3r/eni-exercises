let sentence = "une phrase sans majuscule";
let words = sentence.split(" ");

for (let i = 0; i < words.length; i++) {
    words[i] = words[i][0].toUpperCase() + words[i].substr(1);
}

console.log(words.join(" "));