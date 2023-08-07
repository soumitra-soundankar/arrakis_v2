package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Users
;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    
}
