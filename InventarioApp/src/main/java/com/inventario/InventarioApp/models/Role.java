package com.inventario.InventarioApp.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Role {

    COLABORADOR("Colaborador"),
    SUPERVISOR("Supervisor"),
    JEFE("Jefe"),
    GERENTE("Gerente"),
    SOPORTE("Soporte"),
    DESARROLLADOR("Desarrollador");

    private final String role;

    Role(String role) {
        this.role = role;
    }
}
