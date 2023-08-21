package ro.sda.eventsFinalProject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.eventsFinalProject.model.Register;
import ro.sda.eventsFinalProject.service.RegisterService;

import java.util.List;

@RestController
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService){
        this.registerService = registerService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> createUser(@RequestBody Register register) {
        try {
            // Check if the username is already taken
            if (registerService.isUsernameTaken(register.getUserName())) {
                return ResponseEntity.badRequest().body("Username is already taken");
            }

            Register savedRegister = registerService.saveUser(register);
            return ResponseEntity.ok(savedRegister);
        } catch (IllegalArgumentException iAE) {
            return ResponseEntity.badRequest().body(iAE.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
    @GetMapping("/users")
    public ResponseEntity readAllUsers() {
        List<Register> allRegisters = registerService.getAllUsers();
        return ResponseEntity.ok(allRegisters);
    }
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String userName,@RequestParam String password) {
        // Check if the username and password match an existing user
        boolean isValid = registerService.validateCredentials(userName, password);

        if (isValid) {
            return ResponseEntity.ok().body("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


}
