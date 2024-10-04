package com.inventario.InventarioApp.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceProductDTO {
    private Integer id;
    private String name;
    private Float price;
    private Integer idCategory;
    private MultipartFile photo;
}
