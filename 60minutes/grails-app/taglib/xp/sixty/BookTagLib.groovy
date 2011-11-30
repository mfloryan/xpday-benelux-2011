package xp.sixty

class BookTagLib {
 	static namespace = "sixty"

    def Book = { attrs ->
        def book = attrs.remove("book")
        out << '<div class="book">'
        out << book.title
        out << '</div>'
        out
    }
}
