package com.inventario.InventarioApp.repositories.inventary;

import com.inventario.InventarioApp.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
}
