package mk.ukim.finki;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SI2026Lab2Test {

    // =========================
    // 5. EVERY STATEMENT
    // searchBookByTitle
    // =========================
    @Test
    public void searchBookEveryStatementTest() {

        Library library = new Library();
        library.addBook(new Book("Clean Code", "Robert", "Programming"));

        // 1. Exception path
        assertThrows(IllegalArgumentException.class, () -> {
            library.searchBookByTitle("");
        });

        // 2. Found case
        List<Book> result = library.searchBookByTitle("Clean Code");
        assertNotNull(result);
        assertEquals(1, result.size());

        // 3. Not found case
        List<Book> result2 = library.searchBookByTitle("Nothing");
        assertNull(result2);
    }


    // =========================
    // 7. EVERY BRANCH
    // borrowBook
    // =========================
    @Test
    public void borrowBookEveryBranchTest() {

        Library library = new Library();
        library.addBook(new Book("The Hobbit", "Tolkien", "Fantasy"));

        // 1. invalid input branch
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "");
        });

        // 2. success branch
        library.borrowBook("The Hobbit", "Tolkien");

        // 3. already borrowed branch
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("The Hobbit", "Tolkien");
        });

        // 4. not found branch
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Unknown", "Unknown");
        });
    }


    // =========================
    // 9A. MULTIPLE CONDITION
    // borrowBook condition
    // title.isEmpty() || author.isEmpty()
    // =========================
    @Test
    public void borrowBookMultipleConditionTest() {

        Library library = new Library();

        // TT
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "");
        });

        // TF
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Author");
        });

        // FT
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("Title", "");
        });

        // FF (go deeper into logic → book not found)
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("X", "Y");
        });
    }


    // =========================
    // 9B. MULTIPLE CONDITION
    // searchBookByTitle condition
    // book.getTitle() && !book.isBorrowed()
    // =========================
    @Test
    public void searchBookMultipleConditionTest() {

        Library library = new Library();

        // TT
        library.addBook(new Book("Clean Code", "Robert", "Programming"));
        assertNotNull(library.searchBookByTitle("Clean Code"));

        // TF (borrowed = true)
        Book b2 = new Book("Java", "Author", "Programming");
        b2.setBorrowed(true);
        library.addBook(b2);
        assertNull(library.searchBookByTitle("Java"));

        // FT (wrong title)
        library.addBook(new Book("Python", "Author", "Programming"));
        assertNull(library.searchBookByTitle("Wrong"));

        // FF (wrong title + borrowed)
        Book b4 = new Book("C#", "Author", "Programming");
        b4.setBorrowed(true);
        library.addBook(b4);
        assertNull(library.searchBookByTitle("Nothing"));
    }
}