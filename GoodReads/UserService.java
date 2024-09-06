package GoodReads;

import java.util.*;

public class UserService {
    private static UserService userServiceInstance;
    private final Map<String, User> users;
    private final BookService bookService;

    public static UserService getUserServiceSingleton() {
        if (userServiceInstance == null) {
            userServiceInstance = new UserService();
        }
        return userServiceInstance;
    }

    private UserService() {
        this.users = new HashMap<>();
        this.bookService = BookService.getBookServiceSingleton();
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public User createUser(String name) {
        User user = new User(name);
        users.put(user.getUserId(), user);
        return user;
    }

    public User removeUser(String userId) {
        if (users.containsKey(userId)) {
            return users.remove(userId);
        }
        return null;
    }

    public void addFriend(String userId, String friendId) {
        users.get(userId).getFriends().add(friendId);
    }

    public void addBookToList(String userId, String bookId) {
        User user = users.get(userId);
        if (user != null && bookService.getBooks().containsKey(bookId)) {
            user.getBooks().add(bookId);
            bookService.getBooks().get(bookId).incrementReadCount();
        }
    }

    public List<Book> getTopBooks(int top) {
        return bookService.getBooks().values().stream()
                .sorted(Comparator.comparingInt(Book::getReadCount).reversed())
                .limit(top)
                .toList();
    }

    public List<Book> getTopBooksByFriends(String userId, int top) {
        User user = users.get(userId);
        if (user == null)
            return Collections.emptyList();
        Set<String> friends = user.getFriends();
        Map<String, Integer> bookReadCounts = new HashMap<>();

        for (String friendId : friends) {
            User friend = users.get(friendId);
            if (friend != null) {
                for (String bookId : friend.getBooks()) {
                    bookReadCounts.put(bookId, bookReadCounts.getOrDefault(bookId, 0) + 1);
                }
            }
        }

        PriorityQueue<String> topBooksQueue = new PriorityQueue<>(
                Comparator.comparingInt(bookReadCounts::get));

        for (String bookId : bookReadCounts.keySet()) {
            topBooksQueue.offer(bookId);
            if (topBooksQueue.size() > top) {
                topBooksQueue.poll();
            }
        }

        List<String> topBookIds = new ArrayList<>(topBooksQueue);
        Collections.reverse(topBookIds);

        List<Book> topBooks = new ArrayList<>();
        for (String bookId : topBookIds) {
            topBooks.add(bookService.getBooks().get(bookId));
        }

        return topBooks;

    }

}
