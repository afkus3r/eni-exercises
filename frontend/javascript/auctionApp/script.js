var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var BO;
(function (BO) {
    // Classes
    var Buyer = /** @class */ (function () {
        function Buyer(lastName, firstName) {
            this.lastName = lastName;
            this.firstName = firstName;
        }
        return Buyer;
    }());
    BO.Buyer = Buyer;
    var Author = /** @class */ (function () {
        function Author(lastName, firstName) {
            this.lastName = lastName;
            this.firstName = firstName;
        }
        Author.prototype.display = function () {
            return this.firstName + " " + this.lastName;
        };
        return Author;
    }());
    BO.Author = Author;
    var WorkOfArt = /** @class */ (function () {
        function WorkOfArt(year, title, bestBid, buyer, author) {
            this.year = year;
            this.title = title;
            this.bestBid = bestBid;
            this.buyer = buyer;
            this.author = author;
        }
        WorkOfArt.prototype.bet = function (newBid, buyer) {
            console.log(buyer + " just placed a bid of " + newBid);
        };
        WorkOfArt.prototype.display = function () {
            var authorsList = "";
            this.author.forEach(function (author) {
                authorsList += author.display() + ", ";
            });
            return "This work of art is called " + this.title + " and was made on " + this.year + " by " + authorsList;
        };
        return WorkOfArt;
    }());
    BO.WorkOfArt = WorkOfArt;
    var Sculpture = /** @class */ (function (_super) {
        __extends(Sculpture, _super);
        function Sculpture(year, title, bestBid, buyer, author, matter) {
            var _this = _super.call(this, year, title, bestBid, buyer, author) || this;
            _this.matter = matter;
            return _this;
        }
        Sculpture.prototype.display = function () {
            return _super.prototype.display.call(this);
        };
        return Sculpture;
    }(WorkOfArt));
    BO.Sculpture = Sculpture;
    var painting = /** @class */ (function (_super) {
        __extends(painting, _super);
        function painting(year, title, bestBid, buyer, author) {
            return _super.call(this, year, title, bestBid, buyer, author) || this;
        }
        painting.prototype.display = function () {
            return _super.prototype.display.call(this);
        };
        return painting;
    }(WorkOfArt));
    BO.painting = painting;
    var book = /** @class */ (function (_super) {
        __extends(book, _super);
        function book(year, title, bestBid, buyer, author) {
            return _super.call(this, year, title, bestBid, buyer, author) || this;
        }
        book.prototype.display = function () {
            return _super.prototype.display.call(this);
        };
        return book;
    }(WorkOfArt));
    BO.book = book;
})(BO || (BO = {}));
// Test
var Michel = new BO.Buyer("Michel", "Toulon");
var Rodin = new BO.Author("Jean", "Rodin");
var penserAuthor = [Rodin];
var Penseur = new BO.Sculpture(1999, "Penseur", 65, Michel, penserAuthor, "clay");
console.log(Penseur.display());
