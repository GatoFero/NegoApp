package com.inventario.InventarioApp.servicies.user;


import com.inventario.InventarioApp.entities.User;
import com.inventario.InventarioApp.models.Role;
import com.inventario.InventarioApp.models.UpdateData;
import java.util.List;

public interface UserService{
    User addUser(User user);

    User updateLastname(Integer id, String newLastname);
    User updateFirstname(Integer id, String newFirstname);
    User updatePassword(Integer id, UpdateData data);
    User updateEmail(Integer id, String newEmail);
    User updatePhone(Integer id, String newPhone);
    User updateRole(Integer id, Role role);

    void deleteUser(Integer id);
    List<User> getAllUsers();
    User getUserById(int id);
}
