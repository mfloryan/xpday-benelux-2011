package xp.sixty

import geb.spock.GebSpec

class HomePageSpec extends GebSpec  {

    def setup()
    {
        def books = Book.getAll()
        books.each { book -> book.delete(flush:true) }

    }

    def "Should show empty home page"() {

    given: "An empty app"
    when: "I open the application home page"

        go "/60minutes/"

    then: "I see an empty page"

        title == "60 minutes"
    }

    def "Should list books"() {

        given: "there are some books"
            new Book(title:"Ms Naughty", author: "Mr. Men").save();
            new Book(title:"The Tao of Pooh", author: "Benjamin Hoff").save();

        when: "I open the home page"
            to HomePage

        then: "There are two books"
            at(HomePage)

            firstBook.find("div.title").text() == "Ms Naughty"
            firstBook.find("div.author").text() == "Mr. Men"
            secondBook.find("div.title").text() == "The Tao of Pooh"
            secondBook.find("div.author").text() == "Benjamin Hoff"
    }

    def "Should be able to like a book"() {
        given: "a book with no likes"
            new Book(title:"The Tao of Pooh", author: "Benjamin Hoff").save();

        when: "I open the home page"
            to HomePage

        and: "I like the book"
            firstBook.find("input[value=Like]").click()

        then: "The book has been liked once"
            at(HomePage)

            firstBook.find("div.likes").text() == "1 Likes"
    }
}