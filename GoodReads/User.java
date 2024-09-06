package GoodReads;

import java.util.*;

public class User {
    private String userId;
    private String name;
    private Set<String> friends;
    private Set<String> books;

    public User(String name) {
        this.name = name;
        this.userId = UUID.randomUUID().toString();
        this.friends = new HashSet<>();
        this.books = new HashSet<>();
    }

    public String getUserId() {
        return this.userId;
    }

    public Set<String> getFriends() {
        return this.friends;
    }

    public Set<String> getBooks() {
        return this.books;
    }

}
