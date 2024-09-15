package com.inventario.InventarioApp.servicies;


import com.inventario.InventarioApp.entities.User;

import java.util.List;

public interface UserService {

    User insertUser(User user);
    User updateUser(User user);
    void deleteUser(User user);
    List<User> getAllUsers();
}
