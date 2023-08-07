package com.db.grad.javaapi.model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "BookUser")
public class BookUser {

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
