package com.scm.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Column;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Contact {

    @Id
    private String id;

    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;

    @jakarta.persistence.Column(length=1000)
    private String description;
    private String websiteLink;
    private String linkdInLink;
    private boolean favourite = false;


    // private List<String> socialLink = new ArrayList<>();
   

   @ManyToOne 
   private User user;

   @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
    private List<SocialLink> links = new ArrayList<>();


}
