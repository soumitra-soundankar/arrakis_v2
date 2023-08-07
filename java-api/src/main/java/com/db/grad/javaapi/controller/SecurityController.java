package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecurityController {
    private final SecurityService securityService;

    @Autowired
    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    @GetMapping("/getAllSecurities")
    public List<Security> getAllSecurities() {
        return securityService.getAllSecurities();
    }

    @GetMapping("/security/{id}")
    public ResponseEntity<Object> getSecurityById(@PathVariable("id") long id) {
        try{
            Security security = securityService.findSecurityByID(id);
            return new ResponseEntity<>(security, HttpStatus.OK);
        } catch (ResourceNotFoundException rex) {
            return new ResponseEntity<>(rex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
