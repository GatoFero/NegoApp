package com.inventario.InventarioApp.entities;

import com.inventario.InventarioApp.utiles.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lastname;
    private String firstname;
    private String password;
    private String email;
    private String numberPhone;
    @Enumerated(EnumType.STRING)
    private Role role;
}
