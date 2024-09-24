package com.inventario.InventarioApp.repositories.inventary;

import com.inventario.InventarioApp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
