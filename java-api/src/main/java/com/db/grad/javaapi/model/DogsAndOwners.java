package com.db.grad.javaapi.model;

import org.springframework.data.annotation.Immutable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Immutable
@Table(name="dog_n_owners")
public class DogsAndOwners implements Serializable
{
    @Id
    @Column(name="id", insertable = false, updatable = false)
    private Long id;

    @Column(name="dog_owner")
    private String ownerName;

    @Column(name="dog")
    private String dogName;

    public DogsAndOwners() {
    }

    public Long getId(){
        return id;
    }

    public String getDogName() {
        return dogName;
    }

    public String getOwnerName() {
        return ownerName;
    }
}