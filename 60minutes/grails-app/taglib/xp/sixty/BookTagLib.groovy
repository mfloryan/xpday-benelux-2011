package xp.sixty

class BookTagLib {
 	static namespace = "sixty"

    def Book = { attrs ->
        out << '<div class="book"></div>'
        out
    }
}
