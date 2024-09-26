package com.inventario.InventarioApp.utiles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateData {
    private String credential;
    private String newCredential;
}
