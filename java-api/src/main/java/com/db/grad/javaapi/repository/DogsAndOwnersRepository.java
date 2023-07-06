package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.DogsAndOwners;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name="dog_n_owners")
public interface DogsAndOwnersRepository extends ReadOnlyRepository<DogsAndOwners, Long>
{
    // Because we've used a view we need to customise the query
    @Query(nativeQuery = true, value = "select id, dog_owner, dog from dogs_n_owners")
    List<DogsAndOwners> findAll();
}
