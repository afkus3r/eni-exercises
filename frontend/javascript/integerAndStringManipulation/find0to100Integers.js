let intList = [];
let counter = 0;

function findRandomInt () {
    return Math.floor(Math.random() * 101);
}

do {
    let randomInt = findRandomInt();
    if (!intList.includes(randomInt)) {
        intList.push(randomInt);
    }
    counter++
} while (intList.length < 101);

console.log(intList);
console.log("Les entiers entre 0 et 100 ont été trouvé en " + counter + " tentatives.");