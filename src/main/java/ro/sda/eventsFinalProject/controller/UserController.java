package ro.sda.eventsFinalProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.sda.eventsFinalProject.model.User;
import ro.sda.eventsFinalProject.service.UserService;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity createUser(@RequestBody User user){
        if(user.getId() != null){
            return new ResponseEntity("The id must be empty", HttpStatus.BAD_REQUEST);
        }
        try{
            User savedUser = userService.saveUser(user);
            return new ResponseEntity(savedUser, HttpStatus.OK);
        } catch (IllegalArgumentException iAE){
            return new ResponseEntity(iAE.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
