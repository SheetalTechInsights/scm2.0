package com.scm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scm.entities.User;

@Service
public interface UserService {
    public User saveUser(User user);

    Optional< User> getUserBYId(String id);

    Optional<User> updateUser(User user);

    public void deleteUser(String id);

    boolean isUserExists(String userId);

    boolean isUserExistsByEmail(String email);

    List<User> getAllUsers();

    User getUserByEmail(String email);

}
