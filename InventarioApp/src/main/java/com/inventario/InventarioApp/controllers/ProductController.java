package com.inventario.InventarioApp.controllers;

import com.inventario.InventarioApp.DTOS.ResourceProductDTO;
import com.inventario.InventarioApp.entities.Product;
import com.inventario.InventarioApp.servicies.product.ProductService;
import com.inventario.InventarioApp.utiles.ManageFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.net.MalformedURLException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController implements ManageFile {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@ModelAttribute ResourceProductDTO product){
        Product newProduct = productService.addProduct(product);
        return ResponseEntity.ok(productService.createProductDTO(newProduct));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@ModelAttribute ResourceProductDTO product){
        Product newProduct = productService.updateProduct(product);
        return ResponseEntity.ok(productService.createProductDTO(newProduct));
    }

    @GetMapping("/all/category/{id}")
    public ResponseEntity<?> getAllProductsByCategory(@PathVariable int id){
        return ResponseEntity.ok(productService.getProductsByCategory(id).stream().map(productService::createProductDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProducts().stream().map(productService::createProductDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/photo/{id}")
    public ResponseEntity<?> getProductPhoto(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            File file = new File(getPathProductPhoto(product));
            if (!file.exists()) {
                return ResponseEntity.notFound().build();
            }
            try {
                Resource resource = new UrlResource(file.toURI());
                return ResponseEntity.ok()
                        .contentLength(file.length())
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(resource);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
