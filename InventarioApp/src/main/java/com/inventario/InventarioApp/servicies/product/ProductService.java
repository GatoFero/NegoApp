package com.inventario.InventarioApp.servicies.product;

import com.inventario.InventarioApp.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    Product addProduct(Product product);
    Product addProduct(Product product, MultipartFile photo) throws IOException;
    Product updateProductName(int id, String name);

    Product updateProductPrice(int id, float price);

    Product updatePhotoProduct(int id, MultipartFile newPhoto);

    void deleteProduct(Product product);
    Product getProductById(int id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(int idCategory);
}
