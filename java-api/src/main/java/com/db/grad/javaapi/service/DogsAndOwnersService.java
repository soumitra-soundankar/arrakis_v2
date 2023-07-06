package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.DogsAndOwners;
import com.db.grad.javaapi.repository.DogsAndOwnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogsAndOwnersService
{
    @Autowired
    private DogsAndOwnersRepository dogsAndOwnersRepository;

    public List<DogsAndOwners> getAllDogsAndOwners()
    {
        return dogsAndOwnersRepository.findAll();
    }
}
