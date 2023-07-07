package com.db.grad.javaapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.db.grad.javaapi.service.DogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Dogs;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class DogsController {
    private DogsService dogsService;

    @Autowired
    public DogsController(DogsService ds) {
        dogsService = ds;
    }

    @GetMapping("/dogs")
    public List<Dogs> getAllDogs() {
        return dogsService.getAllDogs();
    }

    @GetMapping("/dogs/{id}")
    public ResponseEntity<Dogs> getEmployeeById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Dogs dogs = dogsService.findDogById(id);
        return ResponseEntity.ok().body(dogs);
    }

    @PostMapping("/dogs")
    public Dogs createDog(@Valid @RequestBody Dogs dogs) {
        return dogsService.saveDogs(dogs);
    }

    @PutMapping("/dogs/{id}")
    public ResponseEntity<Dogs> updateDog(@PathVariable(value = "id") Long id,
                                          @Valid @RequestBody Dogs dogDetails) throws ResourceNotFoundException {

        final Dogs updatedDogs = dogsService.updateDogDetails(id, dogDetails);
        return ResponseEntity.ok(updatedDogs);
    }

    @DeleteMapping("/dogs/{id}")
    public Map<String, Boolean> deleteDog(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Dogs dogs = dogsService.deleteTheDog(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
