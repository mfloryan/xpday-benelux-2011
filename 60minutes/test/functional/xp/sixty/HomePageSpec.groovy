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
}