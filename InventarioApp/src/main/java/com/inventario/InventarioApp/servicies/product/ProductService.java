package com.inventario.InventarioApp.servicies.product;

import com.inventario.InventarioApp.DTOS.ProductDTO;
import com.inventario.InventarioApp.DTOS.ResourceProductDTO;
import com.inventario.InventarioApp.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    Product addProduct(ResourceProductDTO product);
    Product updateProduct(ResourceProductDTO product);

    void setDataProduct(Product product, ResourceProductDTO productDTO);

    String getProductURL(Product product);

    ProductDTO createProductDTO(Product product);

    void deleteProduct(int id);
    Product getProductById(int id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(int idCategory);
}
