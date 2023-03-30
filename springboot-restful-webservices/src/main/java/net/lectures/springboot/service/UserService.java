package net.lectures.springboot.service;

import net.lectures.springboot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(User user);
    String deleteUser(Long id);
}
