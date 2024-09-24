package com.inventario.InventarioApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date sendDate;
    private LocalDateTime receptionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Provider provider;

    @OneToMany(targetEntity = OrderItem.class, mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;
}