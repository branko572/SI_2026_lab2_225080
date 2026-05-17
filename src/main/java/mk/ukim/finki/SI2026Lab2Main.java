package mk.ukim.finki;

public class SI2026Lab2Main {
    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(new Book("Clean Code", "Robert", "Programming"));
        library.addBook(new Book("The Hobbit", "Tolkien", "Fantasy"));

        System.out.println(library.searchBookByTitle("Clean Code"));

        library.borrowBook("The Hobbit", "Tolkien");

        System.out.println("Done");
    }
}