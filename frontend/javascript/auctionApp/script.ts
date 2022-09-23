module BO {
// Interfaces
    export interface Salable {
        bestBid: number;
        buyer: Buyer;

        bet(newBid: number, buyer: Buyer): void;
    }

    export interface Displayable {
        display(): string;
    }

// Classes
    export class Buyer {
        lastName: string;
        firstName: string;

        constructor(lastName: string, firstName: string) {
            this.lastName = lastName;
            this.firstName = firstName;
        }
    }

    export class Author implements Displayable {
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

    export class WorkOfArt implements Salable, Displayable {
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
            let authorsList: string = "";
            this.author.forEach((author) => {
                authorsList += author.display() + ", ";
            })

            return "This work of art is called " + this.title + " and was made on " + this.year + " by " + authorsList;
        }
    }

    export class Sculpture extends WorkOfArt {
        matter: string;

        constructor(year: number, title: string, bestBid: number, buyer: Buyer, author: Author[], matter: string) {
            super(year, title, bestBid, buyer, author);
            this.matter = matter;
        }

        display(): string {
            return super.display();
        }
    }

    export class painting extends WorkOfArt {
        constructor(year: number, title: string, bestBid: number, buyer: Buyer, author: Author[]) {
            super(year, title, bestBid, buyer, author);
        }

        display(): string {
            return super.display();
        }
    }

    export class book extends WorkOfArt {
        constructor(year: number, title: string, bestBid: number, buyer: Buyer, author: Author[]) {
            super(year, title, bestBid, buyer, author);
        }

        display(): string {
            return super.display();
        }
    }
}

// Test
let Michel: BO.Buyer = new BO.Buyer("Michel", "Toulon");
let Rodin: BO.Author = new BO.Author("Jean", "Rodin");
let penserAuthor: BO.Author[] = [Rodin];
let Penseur: BO.Sculpture = new BO.Sculpture(1999, "Penseur", 65, Michel, penserAuthor, "clay");

console.log(Penseur.display());