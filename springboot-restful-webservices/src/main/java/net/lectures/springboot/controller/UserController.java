package net.lectures.springboot.controller;

import lombok.AllArgsConstructor;
import net.lectures.springboot.dto.UserDto;
import net.lectures.springboot.entity.User;
import net.lectures.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor //constructor oluşturmalıyız parametreli.
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){

        return new ResponseEntity<UserDto>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    /*@PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id,@RequestBody User user){
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }*/

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id,@RequestBody UserDto user){
        user.setId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
