package net.lectures.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.lectures.springboot.entity.User;
import net.lectures.springboot.repository.UserRepository;
import net.lectures.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public String deleteUser(Long id) {
        User deletedUser = userRepository.findById(id).get();
        //userRepository.delete(deletedUser);
        userRepository.deleteById(id);
        return deletedUser.getFirstName() +" " + deletedUser.getLastName() + " is deleted successfully.";
    }


}
