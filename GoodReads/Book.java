package GoodReads;

import java.util.UUID;

public class Book {
    private String bookName;
    private String bookId;
    private int readCount;

    public Book(String bookName) {
        this.bookName = bookName;
        this.bookId = UUID.randomUUID().toString();
        this.readCount = 0;
    }

    public String getBookId() {
        return this.bookId;
    }

    public String getBookName() {
        return this.bookName;
    }

    public int getReadCount() {
        return readCount;
    }

    public void incrementReadCount() {
        this.readCount++;
    }
}
