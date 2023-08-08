package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookUserRepository extends JpaRepository<BookUser, Integer> {
    // You can add custom query methods here if needed
}
