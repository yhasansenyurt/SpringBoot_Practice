package net.lectures.springboot.service;

import net.lectures.springboot.dto.UserDto;
import net.lectures.springboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user);
    String deleteUser(Long id);
}
