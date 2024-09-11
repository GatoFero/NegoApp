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
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String industry;
    private String description;
    private String address;
    private String landline;

    @OneToMany(targetEntity = Staff.class, fetch = FetchType.LAZY, mappedBy = "business")
    private List<Staff> staff;
}
