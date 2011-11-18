package xp.sixty

class HomePageController {

    def index = {
        [books: Book.list()]
    }
}
