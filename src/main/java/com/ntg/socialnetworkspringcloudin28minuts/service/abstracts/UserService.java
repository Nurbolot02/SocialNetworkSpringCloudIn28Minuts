package com.ntg.socialnetworkspringcloudin28minuts.service.abstracts;

import com.ntg.socialnetworkspringcloudin28minuts.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findUserById(Long id);
    List<User> findAllUsers();

    void createUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long user);
}
