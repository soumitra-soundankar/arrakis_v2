package com.db.grad.javaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.grad.javaapi.model.Dogs;

@Repository
public interface DogsRepository extends JpaRepository<Dogs, Long>{

}