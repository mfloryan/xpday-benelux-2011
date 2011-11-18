package xp.sixty

import geb.spock.GebSpec

class HomePageSpec extends GebSpec  {

    def "Should show empty home page"() {

    given: "An empty app"
    when: "I open the application home page"

        go "/60minutes/"

    then: "I see an empty page"

        title == "60 minutes"
    }

    def "Should list books"() {

        given: "there are some books"
            def b1 = new Book(title:"Title", author: "Mr. Men");
            b1.save();

        when: "I opeb the home page"

            go "/60minutes"

        then: "There is one book"

            $("div.book").size() == 1

    }
}