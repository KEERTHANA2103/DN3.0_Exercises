import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem {
    private Book[] books;
    private int count;

    public LibraryManagementSystem(int size) {
        books = new Book[size];
        count = 0;
    }

    // Add a book
    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Linear search to find books by title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary search to find books by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = count - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    // Sort books by title
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, count, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
    }

    // Example usage
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem(10);

        // Adding books
        library.addBook(new Book("B1", "Throne of Glass", "F. Scott Fitzgerald"));
        library.addBook(new Book("B2", "Twilight", "George Orwell"));
        library.addBook(new Book("B3", "Pacific Rim", "Harper Lee"));

        // Linear search
        System.out.println("Linear Search:");
        Book foundBook = library.linearSearchByTitle("Twilight");
        System.out.println(foundBook);

        // Sort books
        library.sortBooksByTitle();

        // Binary search
        System.out.println("\nBinary Search:");
        foundBook = library.binarySearchByTitle("Twilight");
        System.out.println(foundBook);
    }
}