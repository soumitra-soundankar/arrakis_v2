package com.db.grad.javaapi.service;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Owners;
import com.db.grad.javaapi.repository.OwnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnersService
{
    @Autowired
    private OwnersRepository ownersRepository;

    public List<Owners> getAllOwners()
    {
        return ownersRepository.findAll();
    }

    public Owners findOwnerById(long id ) throws ResourceNotFoundException
    {
        Owners owners = ownersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found for this id :: " + id));
        return owners;
    }

    public Owners saveOwners(Owners owners )
    {
        return ownersRepository.saveAndFlush(owners);
    }

    public Owners updateDogDetails( long id, Owners newOwnerDetails ) throws ResourceNotFoundException
    {
        Owners ownerToUpdate = ownersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found for this id :: " + id));

        ownerToUpdate.setName(newOwnerDetails.getName());
        final Owners updatedOwner = ownersRepository.save(ownerToUpdate);

        return updatedOwner;
    }

    public Owners deleteTheDog( long id ) throws ResourceNotFoundException
    {
        Owners owners = ownersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found for this id :: " + id));

        ownersRepository.delete(owners);

        return owners;
    }
}