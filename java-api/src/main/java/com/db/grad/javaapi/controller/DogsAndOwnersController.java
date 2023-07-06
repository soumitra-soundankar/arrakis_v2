package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.DogsAndOwners;
import com.db.grad.javaapi.service.DogsAndOwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class DogsAndOwnersController
{
    private DogsAndOwnersService dogsAndOwnersService;

    @Autowired
    public DogsAndOwnersController(DogsAndOwnersService ds)
    {
        dogsAndOwnersService = ds;
    }

    @GetMapping("/getall")
    public List<DogsAndOwners> getAllDogsAndOwners() {
        return dogsAndOwnersService.getAllDogsAndOwners();
    }


}
