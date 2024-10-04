package com.inventario.InventarioApp.DTOS;

import lombok.Builder;

@Builder
public record ProductDTO (
        Integer id,
        String name,
        Float price,
        String category,
        String picture) {
}
