package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.BookUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookUserRepository extends JpaRepository<BookUser, BookUserId> {
    // You can add custom query methods here if needed
}