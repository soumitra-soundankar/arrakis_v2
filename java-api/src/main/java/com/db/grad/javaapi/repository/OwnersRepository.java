package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Owners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnersRepository  extends JpaRepository<Owners, Long> {
}
