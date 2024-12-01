package com.dev.CrudDemo2.rest;

import com.dev.CrudDemo2.model.User;
import com.dev.CrudDemo2.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{theId}")
    User findById(@PathVariable int theId){
        return userService.findById(theId);
    }

    @PostMapping("/users")
    User save(@RequestBody User dbUser){
        dbUser.setId(0);
        return userService.save(dbUser);
    }

    @DeleteMapping("/users/{theId}")
    void deleteById(@PathVariable int theId){
        userService.deleteById(theId);
    }

}
