package com.inventario.InventarioApp.controllers;

import com.inventario.InventarioApp.DTOS.UserCollaboratorDTO;
import com.inventario.InventarioApp.entities.User;
import com.inventario.InventarioApp.utiles.Role;
import com.inventario.InventarioApp.utiles.UpdateData;
import com.inventario.InventarioApp.servicies.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
                .role(user.getRole().getRole())
                .build());
    }

    @GetMapping("/all")
    public ResponseEntity<?> allUsers() {
        return ResponseEntity.ok(userService.getAllUsers().stream().map(user -> UserCollaboratorDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole().getRole())
                .build()).collect(Collectors.toList()));
    }

    //Updates
    @PutMapping("/update/lastname/{id}")
        public ResponseEntity<?> updateLastname(@PathVariable Integer id, @RequestBody User updateUser) {
        User user = userService.updateLastname(id, updateUser);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(UserCollaboratorDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole().getRole())
                .build());
    }
    @PutMapping("/update/firstname/{id}")
    public ResponseEntity<?> updateFirstname(@PathVariable Integer id, @RequestBody User updateUser) {
        User user = userService.updateFirstname(id, updateUser);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(UserCollaboratorDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole().getRole())
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
                .role(user.getRole().getRole())
                .build());
    }
    @PutMapping("/update/email/{id}")
    public ResponseEntity<?> updateEmail(@PathVariable Integer id, @RequestBody User updateUser) {
        User user = userService.updateEmail(id, updateUser);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(UserCollaboratorDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole().getRole())
                .build());
    }
    @PutMapping("/update/numberPhone/{id}")
    public ResponseEntity<?> updateNumberPhone(@PathVariable Integer id, @RequestBody User updateUser) {
        User user = userService.updatePhone(id, updateUser);
        if (user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(UserCollaboratorDTO.builder()
                .id(user.getId())
                .lastname(user.getLastname())
                .firstname(user.getFirstname())
                .numberPhone(user.getNumberPhone())
                .role(user.getRole().getRole())
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
                .role(user.getRole().getRole())
                .build());
    }
}
