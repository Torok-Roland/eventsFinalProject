package ro.sda.eventsFinalProject.service;

import org.springframework.stereotype.Service;
import ro.sda.eventsFinalProject.model.User;
import ro.sda.eventsFinalProject.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User userToBeSaved) {
        if (userToBeSaved == null) {
            throw new IllegalArgumentException("An user must have a body");
        }
        if (userToBeSaved.getUserName() == null) {
            throw new IllegalArgumentException("An user must have a name");
        }
        if (userToBeSaved.getPassword() == null) {
            throw new IllegalArgumentException("An user must have a password");
        }
        User savedUser = userRepository.save(userToBeSaved);
        return savedUser;
    }

    public User findByUserName(String userName) {
        if (userName == null) {
            throw new IllegalArgumentException("User name must not be null!");
        }
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            throw new IllegalArgumentException("There is no user with user name: " + userName);
        }
        return user;
    }


}
