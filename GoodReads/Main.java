package GoodReads;

public class Main {
    public static void main() {
        UserService userService = UserService.getUserServiceSingleton();
        BookService bookService = BookService.getBookServiceSingleton();

        // Create users
        User user1 = userService.createUser("Alice");
        User user2 = userService.createUser("Bob");
        User user3 = userService.createUser("Charlie");

        userService.addFriend(user1.getUserId(), user2.getUserId());
        userService.addFriend(user1.getUserId(), user3.getUserId());

        Book book1 = bookService.addBook("Book One");
        Book book2 = bookService.addBook("Book Two");
        Book book3 = bookService.addBook("Book Three");

        userService.addBookToList(user1.getUserId(), book1.getBookId());
        userService.addBookToList(user2.getUserId(), book1.getBookId());
        userService.addBookToList(user2.getUserId(), book2.getBookId());
        userService.addBookToList(user3.getUserId(), book3.getBookId());
        userService.addBookToList(user3.getUserId(), book1.getBookId());

        // Get top books globally
        System.out.println("Top Books:");
        for (Book book : userService.getTopBooks(2)) {
            System.out.println(book.getBookName() + " - Read Count: " + book.getReadCount());
        }

        System.out.println("\nTop Books by Friends of Alice:");
        for (Book book : userService.getTopBooksByFriends(user1.getUserId(), 2)) {
            System.out.println(book.getBookName() + " - Read Count: " + book.getReadCount());
        }
    }
}
