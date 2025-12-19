package com.scm.helper;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String mesaage) {
        super(mesaage);
    }

    public ResourceNotFoundException() {
    super("Resource Not Found!");
   }


}
