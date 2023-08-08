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
public class BookUser {

    // @Id
    // private int bookId;

    // @Id
    // private int userId;

    // // Default constructor (required by JPA)
    // public BookUser() {}

    // public BookUser(int bookId, int userId) {
    //     this.bookId = bookId;
    //     this.userId = userId;
    // }

    // // Getters and Setters (you can generate them using your IDE or write them manually)
    // public int getBookId() {
    //     return bookId;
    // }

    // public void setBookId(int bookId) {
    //     this.bookId = bookId;
    // }

    // public int getUserId() {
    //     return userId;
    // }

    // public void setUserId(int userId) {
    //     this.userId = userId;
    // }

    // // toString() method (optional, for better logging or debugging)
    // @Override
    // public String toString() {
    //     return "BookUser [bookId= " + bookId + ", userId= "  + userId + "]";
    // }
    @Id
    private int id; // Assuming this is the primary key for the join table

    @ManyToOne
    @JoinColumn(name = "BookId", referencedColumnName = "Id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "Id", nullable = false)
    private Users users;

    // Constructors, getters, and setters

    public BookUser() {
        // Default constructor required by JPA
    }

    public BookUser(Book book, Users users) {
        this.book = book;
        this.users = users;
    }

    // Getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }
}
