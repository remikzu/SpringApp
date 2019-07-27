package pl.sda.taskmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Remigiusz Zudzin
 */

//nasluchiwanie na żądania protokołu HTTP
@RestController
public class UserController {

    //żądania http: GET, POST, PUT, DELETE
    @GetMapping("/")
    public String getName() {
        return "hello";
    }

    @GetMapping("/{user_name}")
    public String getUserName(@PathVariable String user_name) {
        return "hello " + user_name;
    }

}
