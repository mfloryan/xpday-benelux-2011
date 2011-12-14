package sixtyminutes

class HomePageController {

    def index = {
        [books: Book.list()]
    }
}
