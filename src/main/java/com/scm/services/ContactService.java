package com.scm.services;

import java.util.List;

import com.scm.entities.Contact;
import com.scm.entities.User;

public interface ContactService {
    //All methods
 
    //save user
    Contact save(Contact contact);
     
    //update user

    Contact update(Contact contact);
     
    //get user

    List<Contact> getAll();

    //get by id

    Contact getById(String id);
     
    //delete contact

    void delete(String id);
     
    //search

    List<Contact> search(String name, String email, String phoneNumber);

    //get contact by user id

    List<Contact> getByUserId(String id);

    List<Contact> getByUser(User user);
    
}
