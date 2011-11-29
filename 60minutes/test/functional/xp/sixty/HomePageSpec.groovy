package xp.sixty

import geb.spock.GebSpec
import org.codehaus.groovy.grails.commons.ApplicationHolder

class HomePageSpec extends GebSpec  {

    def fixtureLoader = ApplicationHolder.application?.mainContext?.fixtureLoader

    def setup() {
		fixtureLoader.load "tearDown"
	}

    def "Should show empty home page"() {

    given: "An empty app"
    when: "I open the application home page"

        go "/60minutes/"

    then: "I see an empty page"

        title == "60 minutes"
        $("div.book").size() == 0
    }

    def "Should list books"() {

        given: "I have the Mr. Happy book"

            def fixture = fixtureLoader.load {
                mrHappy(Book) {
                    author = "Roger Hargreaves"
                    title = "Mr. Happy"
                }
            }

        when: "I open the home page"

            go "/60minutes"

        then: "There is one book"

            $("div.book").size() == 1
    }
}
