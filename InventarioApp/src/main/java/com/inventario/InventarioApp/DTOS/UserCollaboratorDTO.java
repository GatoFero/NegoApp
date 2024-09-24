package com.inventario.InventarioApp.DTOS;

import com.inventario.InventarioApp.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCollaboratorDTO {
    private Integer id;
    private String lastname;
    private String firstname;
    private String numberPhone;
    private String role;
}
