package com.inventario.InventarioApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String numberPhone;
    private String role;

    @OneToMany(targetEntity = Staff.class, fetch = FetchType.LAZY, mappedBy = "user")
    private List<Staff> staff;
}
