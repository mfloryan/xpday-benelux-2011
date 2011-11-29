package xp.sixty

class HomePageController {

    def index = {
        [books: Book.list()]
    }

    def like = {
        def book = Book.get(params.id)
        book.likes += 1
        book.save()

        redirect(action:index)
    }
}
