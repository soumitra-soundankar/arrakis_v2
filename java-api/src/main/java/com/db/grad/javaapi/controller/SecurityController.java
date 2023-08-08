package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SecurityController {
    private final SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/getAllSecurities")
    public ResponseEntity<List<Security>> getAllSecurities() {
        try {
            return new ResponseEntity<>(securityService.getAllSecurities(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/security/{id}")
    public ResponseEntity<Security> getSecurityById(@PathVariable("id") long id) {
        try{
            Security security = securityService.findSecurityByID(id);
            return new ResponseEntity<>(security, HttpStatus.OK);
        } catch (ResourceNotFoundException rex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createSecurity")
    public ResponseEntity<Security> createNewSecurity(Security security) {
        try {
            return new ResponseEntity<>(securityService.createNewSecurity(security), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateSecurity")
    public ResponseEntity<Security> updateSecurity(Security security) {
        try {
            return new ResponseEntity<>(securityService.updateSecurity(security), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteSecurity")
    public ResponseEntity<HttpStatus> deleteSecurity(String isin) {
        try {
            securityService.deleteSecurityByIsin(isin);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException rex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
