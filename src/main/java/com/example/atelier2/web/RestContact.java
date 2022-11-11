package com.example.atelier2.web;

import com.example.atelier2.entities.Contact;
import com.example.atelier2.dao.ContactRepository;
import com.example.atelier2.exceptions.ContactNotfoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class RestContact {
    @Autowired
    ContactRepository contactRepository;
    @GetMapping ("/{id}")
    public Contact getContactById (@PathVariable Long id )  {
        try{
        return contactRepository.findById(id).get();}
        catch ( Exception e) {
            throw new RuntimeException("this user does not exist" + e.getMessage());

        }

    }
    @GetMapping
    public List<Contact> getAllSociety (){

        return contactRepository.findAll();
    }

    @PostMapping
    public Contact saveContact(@RequestBody Contact newContact) {

        return contactRepository.save(newContact);
    }
    @PutMapping("/{id}")

    public ResponseEntity<Contact> updatedOffre (@PathVariable Long id , @RequestBody Contact detailsContact ){
        Contact updateContact = contactRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with id "+ id+ " does not exist"));
        updateContact.setId(detailsContact.getId());
        updateContact.setNom(detailsContact.getNom());
        updateContact.setPrenom(detailsContact.getPrenom());
        updateContact.setDateNaissance(detailsContact.getDateNaissance());
        updateContact.setTelephone(detailsContact.getTelephone());
        contactRepository.save(updateContact);
        return ResponseEntity.ok(updateContact);
    }

    @DeleteMapping("/{id}")
    public  void deleteSociety(@PathVariable Long id ){
        contactRepository.deleteById(id);
    }
}


