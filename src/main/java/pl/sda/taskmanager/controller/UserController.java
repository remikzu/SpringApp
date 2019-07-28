package pl.sda.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.taskmanager.model.User;
import pl.sda.taskmanager.model.dto.UserDto;
import pl.sda.taskmanager.service.UserService;

import java.util.List;

/**
 * @author Remigiusz Zudzin
 */

//nasluchiwanie na żądania protokołu HTTP
@RestController
public class UserController {

    private UserService userService;

    //żądania http: GET, POST, PUT, DELETE
    @GetMapping("/")
    public String getName() {
        return "hello";
    }

    @GetMapping("/user/{user_name}")
    public String getUserName(@PathVariable String user_name) {
        return "hello " + user_name;
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register/{name}&{lastname}&{email}&{password}")
    public User addUser(
            @PathVariable String name,
            @PathVariable String lastname,
            @PathVariable String email,
            @PathVariable String password
    ) {
        return userService.addUser(new UserDto(name, lastname, email, password));
    }

    @GetMapping("/login_user/{email}&{password}")
    public String login(
            @PathVariable String email,
            @PathVariable String password
    ) {
        return userService.loginUser(email, password);
    }
}
