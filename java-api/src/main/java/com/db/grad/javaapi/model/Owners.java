package com.db.grad.javaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "owners")
public class Owners {

    @Id
    private long ownerId;
    private String name;

    public Owners() {

    }

    public Owners(long id, String name, long age) {
        this.ownerId=id;
        this.name = name;
    }

    @Id
    @Column(name = "owner_id", nullable = false)
    public long getId() {
        return ownerId;
    }
    public void setId(long id) {
        this.ownerId = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}