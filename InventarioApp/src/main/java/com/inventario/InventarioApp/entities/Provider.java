package com.inventario.InventarioApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Provider{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String industry;
    private String ruc;
    private String email;
    private String landline;
    private String address;

    @OneToMany(targetEntity = Order.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "provider")
    private List<Order> orders;
}
