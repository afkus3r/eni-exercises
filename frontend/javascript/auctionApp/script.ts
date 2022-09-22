// Interfaces

interface Salable {
    bestBid: number;
    buyer: Buyer;

    bet(newBid: number, buyer: Buyer): void;
}

interface Displayable {
    display(): string;
}

// Classes

class Buyer {
    lastName: string;
    firstName: string;

    constructor(lastName: string, firstName: string) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}

class Author implements Displayable {
    lastName: string;
    firstName: string;

    constructor(lastName: string, firstName: string) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    display(): string {
        return this.firstName + " " + this.lastName;
    }
}

class WorkOfArt implements Salable, Displayable {
    year: number;
    title: string;
    bestBid: number;
    buyer: Buyer;
    author: Author[];

    constructor(year: number, title: string, bestBid: number, buyer: Buyer, author: Author[]) {
        this.year = year;
        this.title = title;
        this.bestBid = bestBid;
        this.buyer = buyer;
        this.author = author;
    }

    bet(newBid: number, buyer: Buyer): void {
        console.log(buyer + " just placed a bid of " + newBid);
    }

    display(): string {
        return "This work of art is called " + this.title + " and was made on " + this.year + " by " + this.author;
    }
}

class Sculpture extends WorkOfArt {
    matter: string;

    constructor(year: number, title: string, bestBid: number, buyer: Buyer, author: Author[], matter: string) {
        super(year, title, bestBid, buyer, author);
        this.matter = matter;
    }
}

class painting extends WorkOfArt {
    constructor(year: number, title: string, bestBid: number, buyer: Buyer, author: Author[]) {
        super(year, title, bestBid, buyer, author);
    }
}

class book extends WorkOfArt {
    constructor(year: number, title: string, bestBid: number, buyer: Buyer, author: Author[]) {
        super(year, title, bestBid, buyer, author);
    }
}

// Test

let Michel : Buyer = new Buyer("Michel", "Toulon");
let Rodin : Author = new Author("Jean", "Rodin");
let penserAuthor : Author[] = [Rodin];
let Penseur : Sculpture = new Sculpture(1999, "Penseur", 65, Michel, penserAuthor, "clay");

Penseur.display();