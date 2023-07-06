package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.DogsAndOwners;
import com.db.grad.javaapi.model.Owners;
import com.db.grad.javaapi.repository.DogsAndOwnersRepository;
import com.db.grad.javaapi.service.OwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class OwnersController {
    private OwnersService ownersService;

    @Autowired
    DogsAndOwnersRepository dogsAndOwnersRepository;

    @Autowired
    public OwnersController(OwnersService ds)
    {
        ownersService = ds;
    }

    @GetMapping("/owners")
    public List<Owners> getAllDogs() {
        return ownersService.getAllOwners();
    }

    @GetMapping("/combi")
    public List<DogsAndOwners> getBoth() {
        return dogsAndOwnersRepository.findAll();
    }

    @GetMapping("/owners/{id}")
    public ResponseEntity< Owners > getEmployeeById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Owners owners = ownersService.findOwnerById(id);
        return ResponseEntity.ok().body(owners);
    }

    @PostMapping("/owners")
    public Owners createDog(@Valid @RequestBody Owners owners) {
        return ownersService.saveOwners(owners);
    }

    @PutMapping("/owners/{id}")
    public ResponseEntity < Owners > updateDog(@PathVariable(value = "id") Long id,
                                             @Valid @RequestBody Owners ownerDetails) throws ResourceNotFoundException {

        final Owners updatedOwners = ownersService.updateDogDetails(id, ownerDetails);
        return ResponseEntity.ok(updatedOwners);
    }

    @DeleteMapping("/owners/{id}")
    public Map< String, Boolean > deleteDog(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        ownersService.deleteTheDog(id);

        Map < String, Boolean > response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
