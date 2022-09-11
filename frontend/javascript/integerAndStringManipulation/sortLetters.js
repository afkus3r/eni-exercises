let sentence = "une chaine avec des lettres dans unn certain ordre pour donner du sens";

sentence = sentence.replace(/ /g, '');

console.log(sentence.split('').sort().join(''));