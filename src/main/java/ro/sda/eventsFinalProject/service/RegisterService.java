package ro.sda.eventsFinalProject.service;

import org.springframework.stereotype.Service;
import ro.sda.eventsFinalProject.model.Register;
import ro.sda.eventsFinalProject.repository.RegisterRepository;

import java.util.List;

@Service
public class RegisterService {
    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public boolean isUsernameTaken(String username) {
        Register register = registerRepository.findByUserName(username);
        return register != null;
    }

    public Register saveUser(Register registerToBeSaved) {
        if (registerToBeSaved == null) {
            throw new IllegalArgumentException("An user must have a body");
        }
        if (registerToBeSaved.getUserName() == null) {
            throw new IllegalArgumentException("An user must have a name");
        }
        if (registerToBeSaved.getPassword() == null) {
            throw new IllegalArgumentException("An user must have a password");
        }
        if (isUsernameTaken(registerToBeSaved.getUserName())) {
            throw new IllegalArgumentException("Username is already taken");
        }

        // Save the user to the database
        Register savedRegister = registerRepository.save(registerToBeSaved);

        return savedRegister;
    }

    public List<Register> getAllUsers() {
        return registerRepository.findAll();
    }
    public boolean validateCredentials(String username, String password) {
        // Lookup the user by the provided username
        Register user = registerRepository.findByUserName(username);

        if (user != null) {
            // Compare the provided password with the user's password
            return user.getPassword().equals(password);
        }

        return false; // User not found or password doesn't match
    }


//    public Register registerUser(String userName, String password) {
//        if (userName == null || password == null) {
//            return null;
//        } else {
//            Register register = new Register();
//            register.setUserName(userName);
//            register.setPassword(password);
//            return registerRepository.save(register);
//        }
//    }
}
