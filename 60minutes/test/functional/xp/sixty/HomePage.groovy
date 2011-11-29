package xp.sixty

import geb.*

class HomePage extends Page {
    static url = "/60minutes"
    static at = { title == "60 minutes" }
    static content = {
        books { $("div.book") }
        bookWithTitle { books.find({b -> b.find("div.title").text() == "The Tao of Pooh Bear"}) }
        firstBook { books[0] }
        secondBook { books[1] }
    }
}
