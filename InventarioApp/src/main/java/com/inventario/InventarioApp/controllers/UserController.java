package com.inventario.InventarioApp.controllers;

import com.inventario.InventarioApp.DTOS.UserCollaboratorDTO;
import com.inventario.InventarioApp.entities.User;
import com.inventario.InventarioApp.models.Role;
import com.inventario.InventarioApp.models.UpdateData;
import com.inventario.InventarioApp.servicies.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //CRUD
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        User user = userService.getUserById(id);

        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(UserCollaboratorDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole().toString())
                .build());
    }

    @GetMapping("/all")
    public ResponseEntity<?> allUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users.stream().map(user -> UserCollaboratorDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole().toString())
                .build()).collect(Collectors.toList()));
    }

    //Updates
    @PutMapping("/update/lastname/{id}")
    public ResponseEntity<?> updateLastname(@PathVariable Integer id, @RequestBody String lastname) {
        User user = userService.updateLastname(id, lastname);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(UserCollaboratorDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole().toString())
                .build());
    }
    @PutMapping("/update/firstname/{id}")
    public ResponseEntity<?> updateFirstname(@PathVariable Integer id, @RequestBody String firstname) {
        User user = userService.updateFirstname(id, firstname);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(UserCollaboratorDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole().toString())
                .build());
    }
    @PutMapping("/update/password/{id}")
    public ResponseEntity<?> updatePassword(@PathVariable Integer id, @RequestBody UpdateData updateData) {
        User user = userService.updatePassword(id, updateData);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(UserCollaboratorDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole().toString())
                .build());
    }
    @PutMapping("/update/email/{id}")
    public ResponseEntity<?> updateEmail(@PathVariable Integer id, @RequestBody String email) {
        User user = userService.updateEmail(id, email);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(UserCollaboratorDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole().toString())
                .build());
    }
    @PutMapping("/update/numberPhone/{id}")
    public ResponseEntity<?> updateNumberPhone(@PathVariable Integer id, @RequestBody String numberPhone) {
        User user = userService.updatePhone(id, numberPhone);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(UserCollaboratorDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole().toString())
                .build());
    }
    @PutMapping("/update/role/{id}")
    public ResponseEntity<?> updateRole(@PathVariable Integer id, @RequestBody Role role) {
        User user = userService.updateRole(id, role);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(UserCollaboratorDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole().toString())
                .build());
    }
}
