package com.inventario.InventarioApp.repositories.logistics;

import com.inventario.InventarioApp.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
