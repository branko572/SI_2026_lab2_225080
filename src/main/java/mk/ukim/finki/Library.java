package mk.ukim.finki;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> searchBookByTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Invalid title");
        }

        List<Book> results = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed()) {
                results.add(book);
            }
        }

        if (results.isEmpty()) {
            return null;
        }

        return results;
    }

    public void borrowBook(String title, String author) {
        if (title == null || author == null || title.isEmpty() || author.isEmpty()) {
            throw new IllegalArgumentException("Invalid search query");
        }

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)
                    && book.getAuthor().equalsIgnoreCase(author)) {

                if (!book.isBorrowed()) {
                    book.setBorrowed(true);
                    return;
                } else {
                    throw new RuntimeException("Book already borrowed");
                }
            }
        }

        throw new RuntimeException("Book not found");
    }
}