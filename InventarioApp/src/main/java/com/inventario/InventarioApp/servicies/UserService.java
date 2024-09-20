package com.inventario.InventarioApp.servicies;


import com.inventario.InventarioApp.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService{
    //Importante
    User addUser(User user);

    User updateUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers();

    //Importante
    Optional<User> getUserById(int id);
}
