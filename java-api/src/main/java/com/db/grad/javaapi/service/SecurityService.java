package com.db.grad.javaapi.service;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SecurityService {
    @Autowired
    private SecurityRepository securityRepository;

    public List<Security> getAllSecurities() {
        return securityRepository.findAll();
    }

    public Security findSecurityByID(long id) throws ResourceNotFoundException {
        return securityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Security with id = " + id + " not found"));
    }

    public Security createNewSecurity(Security security) {
        return securityRepository.save(security);
    }

    public Security updateSecurity(Security updatedSecurity) throws ResourceNotFoundException {
        Security security = securityRepository.findById(updatedSecurity.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Security with id = " + updatedSecurity.getId() + " not found"));
        return securityRepository.save(updatedSecurity);
    }

    @Transactional
    public void deleteSecurityByIsin(String isin) throws ResourceNotFoundException {
        if(securityRepository.existsByIsin(isin)) {
            securityRepository.deleteByIsin(isin);
        } else {
            throw new ResourceNotFoundException("Security with isin = " + isin + " not found");
        }
    }
}
