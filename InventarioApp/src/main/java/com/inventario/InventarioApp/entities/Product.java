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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String picture;
    private Float price;

    @ManyToOne
    private Category category;

    @OneToMany(targetEntity = Stock.class, mappedBy = "product", fetch = FetchType.LAZY)
    private List<Stock> stocks;
}
