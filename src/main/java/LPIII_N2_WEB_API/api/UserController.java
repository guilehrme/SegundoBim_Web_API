package LPIII_N2_WEB_API.api;

import  LPIII_N2_WEB_API.model.User;
import  LPIII_N2_WEB_API.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("api/Formula1User")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping
    public List<User> listUser() {
        return userService.listUser();
    }

    @GetMapping(path = "{id}")
    public User retrieveUserById(@PathVariable("id") UUID id) {
        return userService.retrieveUserById(id)
                .orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") UUID id) {
        userService.deleteUser(id);
    }
    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") UUID id, @RequestBody User user) {
        userService.updateUser(id,user);
    }
}
