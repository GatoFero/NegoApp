package com.inventario.InventarioApp.servicies.user;

import com.inventario.InventarioApp.entities.User;
import com.inventario.InventarioApp.utiles.UpdateData;
import com.inventario.InventarioApp.repositories.UserRepository;
import org.springframework.stereotype.Service;
import com.inventario.InventarioApp.models.Role;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.findById(id).ifPresent(userRepository::delete);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updatePassword(Integer id, UpdateData data) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado."));

        if(!user.getPassword().equals(data.getCredential()))
            throw new IllegalArgumentException("Contraseña no coincide.");

        user.setPassword(data.getNewCredential());
        return userRepository.save(user);
    }

    @Override
    public User updateEmail(Integer id, User updateUser) {
        return userRepository.findById(id)
                .filter(user -> !user.getEmail().equals(updateUser.getEmail()))
                .map(user ->{
                    user.setEmail(updateUser.getEmail());
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    @Override
    public User updatePhone(Integer id, User updateUser) {
        return userRepository.findById(id)
                .filter(user -> !user.getNumberPhone().equals(updateUser.getNumberPhone()))
                .map(user -> {
                    user.setNumberPhone(updateUser.getNumberPhone());
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    @Override
    public User updateRole(Integer id, Role role) {
        if (role == null) throw new IllegalArgumentException("El rol no puede ser nulo.");

        return userRepository.findById(id)
                .filter(user -> !user.getRole().equals(role))
                .map(user -> {
                    user.setRole(role);
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    @Override
    public User updateLastname(Integer id, User updateUser) {
        return userRepository.findById(id)
                .filter(user -> !user.getLastname().equals(updateUser.getLastname()))
                .map(user -> {
                    user.setLastname(updateUser.getLastname());
                    return userRepository.save(user);
                })
                .orElse(null);
    }
    @Override
    public User updateFirstname(Integer id, User updateUser) {
        return userRepository.findById(id)
                .filter(user -> !user.getFirstname().equals(updateUser.getFirstname()))
                .map(user -> {
                    user.setLastname(updateUser.getFirstname());
                    return userRepository.save(user);
                })
                .orElse(null);
    }
}
