package xp.sixty

import geb.spock.GebSpec

class HomePageSpec extends GebSpec  {

    def setup()
    {
        def books = Book.getAll()
        books.each { book -> book.delete() }
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
            new Book(title:"Watchmen", author: "Alan Moore").save();

        when: "I open the home page"
            to HomePage

        then: "There are two books"
            at(HomePage)

            firstBook.find("div.title").text() == "Ms Naughty"
            firstBook.find("div.author").text() == "Mr. Men"
            secondBook.find("div.title").text() == "Watchmen"
            secondBook.find("div.author").text() == "Alan Moore"
    }

    def "Should be able to like a book"() {
        given: "a book with no likes"
            new Book(title:"The Tao of Pooh Bear", author: "Benjamin Hoff").save();

        when: "I open the home page"
            to HomePage

        and: "I like the book"
            bookWithTitle("The Tao of Pooh Bear").find("input[value=Like]").click()

        then: "The book has been liked once"
            at(HomePage)

            bookWithTitle("The Tao of Pooh Bear").find("div.likes").text() == "1 Like"
    }

    def "Should be able to like a book more than once"() {
        given: "a book with one likes"
            new Book(title:"The Tao of Pooh", author: "Benjamin Hoff", likes: 1).save();

        when: "I open the home page"
            to HomePage

        and: "I like the book"
            bookWithTitle("The Tao of Pooh").find("input[value=Like]").click()

        then: "The book has been liked twice"
            at(HomePage)

            bookWithTitle("The Tao of Pooh").find("div.likes").text() == "2 Likes"
    }
}