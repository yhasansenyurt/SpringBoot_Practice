package net.lectures.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.lectures.springboot.dto.UserDto;
import net.lectures.springboot.entity.User;
import net.lectures.springboot.mapper.UserMapper;
import net.lectures.springboot.repository.UserRepository;
import net.lectures.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        // Convert UserDto into User JPA Entity
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        // Convert User JPA entity to UserDto
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);

        //Convert User JPA into UserDto
        return UserMapper.mapToUserDto(optionalUser.get());
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        /*List<UserDto> userDtos = new ArrayList<>();
        for(User user : users){
            userDtos.add(UserMapper.mapToUserDto(user));
        }*/
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        User existingUser = userRepository.findById(userDto.getId()).get();
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        return UserMapper.mapToUserDto(userRepository.save(existingUser));
    }

    @Override
    public String deleteUser(Long id) {
        User deletedUser = userRepository.findById(id).get();
        //userRepository.delete(deletedUser);
        userRepository.deleteById(id);
        return deletedUser.getFirstName() +" " + deletedUser.getLastName() + " is deleted successfully.";
    }


}
