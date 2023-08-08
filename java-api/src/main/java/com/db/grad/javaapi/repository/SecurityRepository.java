package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long> {
    List<Security> findAll();
    Optional<Security> findById(long id);
    void deleteByIsin(String isin);
    boolean existsByIsin(String isin);
}
