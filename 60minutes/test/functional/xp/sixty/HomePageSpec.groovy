package xp.sixty

import geb.spock.GebSpec
import sixtyminutes.Book

/* Created 01/12/11 08:41 by mfloryan */

class HomePageSpec extends GebSpec {

    def setup() {
        Book.list()*.delete()
    }

    def "When I open the 60 minute application I should see one book"() {

        given: "A book"


        def book = fixtureLoader.load {
            book1(Book) {
                title ="Down the rabbit hole"
            }
        }

        when: "Go to 60 minutes"
        to HomePage

        then: "I can see only one book"
        page.books == ['Down the rabbit hole']

    }

    def "When I open the 60 minutes application I should see a list of books"() {
        given: "Two Books"

        def firstBook = new Book(title:"Down the rabbit hole")
        firstBook.save()
        def secondBook = new Book(title:"The Tao of Pooh")
        secondBook.save()

        when: "Go to 60 minutes"
        to HomePage

        then: "I can see a list of books"
        page.books == ['Down the rabbit hole', 'The Tao of Pooh']

    }

}
