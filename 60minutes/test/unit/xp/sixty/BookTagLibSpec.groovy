package xp.sixty

import grails.plugin.spock.TagLibSpec

class BookTagLibSpec extends TagLibSpec {

    def "Should display single book correctly"() {

        given: "a book"
        def book = new Book();

        when: "I render it"
        String out = Book(book:book)

        then: "I get expected markup"
        out == '<div class="book"></div>'
    }

}
