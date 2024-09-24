package com.inventario.InventarioApp.repositories.logistics;

import com.inventario.InventarioApp.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {
}