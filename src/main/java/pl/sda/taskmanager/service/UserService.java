package pl.sda.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.taskmanager.model.User;
import pl.sda.taskmanager.model.dto.UserDto;
import pl.sda.taskmanager.repository.RoleRepository;
import pl.sda.taskmanager.repository.UserRepository;

import java.util.List;

/**
 * @author Remigiusz Zudzin
 */

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    //wypisz wszystkich uzytkowników
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //rejestracja uzytkownika
    public User addUser(UserDto user) {
        //utwórz obiekt User
        User registered_user =
                new User(
                        user.getName(),
                        user.getLastname(),
                        user.getEmail(),
                        user.getPassword());
        registered_user.addRole(roleRepository.getOne(1L));
        return userRepository.save(registered_user);
    }

    public String loginUser(String email, String password) {
        User user = userRepository.findFirstByEmailAndPassword(email, password);
        if (user == null) {
            return "błąd logowania";
        }
        return "zalogowano: " + user.toString();
    }
}
