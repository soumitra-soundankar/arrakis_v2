package com.db.grad.javaapi.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false, length = 255)
    private String user_name;

    @Column(nullable = false, length = 255)
    private String Email;

    @Column(length = 50)
    private String user_role;

    // Constructors, getters, and setters

    public Users() {
        // Default constructor required by JPA
    }

    public Users(String name, String email, String role) {
        this.user_name = name;
        this.Email = email;
        this.user_role = role;
    }

    // Getters and setters for all fields

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return user_name;
    }

    public void setName(String name) {
        this.user_name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getRole() {
        return user_role;
    }

    public void setRole(String role) {
        this.user_role = role;
    }
}
