package com.db.grad.javaapi.model;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Users;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BookUser")
@IdClass(BookUserId.class)
public class BookUser {

    @Id
    private int bookId;

    @Id
    private int userId;

    // Default constructor (required by JPA)
    public BookUser() {}

    public BookUser(int bookId, int userId) {
        this.bookId = bookId;
        this.userId = userId;
    }

    // Getters and Setters (you can generate them using your IDE or write them manually)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // toString() method (optional, for better logging or debugging)
    @Override
    public String toString() {
        return "BookUser [bookId= " + bookId + ", userId= "  + userId + "]";
    }
}
