package com.inventario.InventarioApp.servicies.product;

import com.inventario.InventarioApp.entities.Product;
import java.util.List;

public interface ProductService {

    Product addProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Product product);
    Product getProductById(int id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
}
