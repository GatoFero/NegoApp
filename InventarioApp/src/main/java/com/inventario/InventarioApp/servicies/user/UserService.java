package com.inventario.InventarioApp.servicies.user;


import com.inventario.InventarioApp.entities.User;
import com.inventario.InventarioApp.utiles.Role;
import com.inventario.InventarioApp.utiles.UpdateData;
import java.util.List;

public interface UserService{
    User addUser(User user);

    User updateLastname(Integer id, User updateUser);
    User updateFirstname(Integer id, User updateUser);
    User updatePassword(Integer id, UpdateData updateData);
    User updateEmail(Integer id, User updateUser);
    User updatePhone(Integer id, User updateUser);
    User updateRole(Integer id, Role role);

    void deleteUser(Integer id);
    List<User> getAllUsers();
    User getUserById(int id);
}
