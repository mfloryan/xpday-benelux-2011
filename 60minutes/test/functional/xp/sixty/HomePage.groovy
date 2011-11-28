package xp.sixty

import geb.*

class HomePage extends Page {
    static url = "/60minutes"
    static at = { title == "60 minutes" }
    static content = {
        books { $("div.book") }
        firstBook { books[0] }
        secondBook { books[1] }
    }
}
