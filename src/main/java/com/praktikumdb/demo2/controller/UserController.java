package com.praktikumdb.demo2.controller;

import com.praktikumdb.demo2.model.User;
import com.praktikumdb.demo2.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User request) {
        return userService.addUser(request);
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}") // Perbaikan: Pakai {id}
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}") // Perbaikan: Pakai {id}
    public String updateUser(@PathVariable String id, @RequestBody User request) {
        userService.updateUser(id, request);
        return "user updated successfully";
    }

    @DeleteMapping("/{id}") // Perbaikan: Pakai {id}
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "user deleted successfully";
    }
}