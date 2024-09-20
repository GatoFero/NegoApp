package com.inventario.InventarioApp.controllers;

import com.inventario.InventarioApp.entities.User;
import com.inventario.InventarioApp.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> allUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
