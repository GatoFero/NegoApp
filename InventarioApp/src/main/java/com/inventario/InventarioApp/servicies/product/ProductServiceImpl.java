package com.inventario.InventarioApp.servicies.product;

import com.inventario.InventarioApp.DTOS.ProductDTO;
import com.inventario.InventarioApp.DTOS.ResourceProductDTO;
import com.inventario.InventarioApp.entities.Category;
import com.inventario.InventarioApp.entities.Product;
import com.inventario.InventarioApp.repositories.inventary.CategoryRepository;
import com.inventario.InventarioApp.repositories.inventary.ProductRepository;
import com.inventario.InventarioApp.utiles.ManageFile;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService, ManageFile {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product addProduct(ResourceProductDTO product) {
        Product newProduct = new Product();
        productRepository.save(newProduct);
        setDataProduct(newProduct, product);
        if(product.getPhoto() != null) {
            try {
                transferPhoto(product.getPhoto(), setPathProductPhoto(newProduct, product.getPhoto()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(ResourceProductDTO productDTO){
        return productRepository.findById(productDTO.getId())
                .map(product -> {
                    setDataProduct(product, productDTO);
                    if(productDTO.getPhoto() != null){
                        try {
                            String photoPath = setPathProductPhoto(product, productDTO.getPhoto());
                            deletePhoto(photoPath);
                            transferPhoto(productDTO.getPhoto(), photoPath);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado."));
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.delete(getProductById(id));
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado."));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(int idCategory) {
        if (!categoryRepository.existsById(idCategory)) {
            throw new EntityNotFoundException("Categoría no encontrada");
        }
        return productRepository.findByCategoryId(idCategory);
    }

    @Override
    public void setDataProduct(Product product, ResourceProductDTO productDTO){
        if(productDTO.getName() != null) product.setName(productDTO.getName());
        if(productDTO.getPrice() != null) product.setPrice(productDTO.getPrice());
        if(productDTO.getIdCategory() != null) product.setCategory(categoryRepository.getReferenceById(productDTO.getIdCategory()));
    }

    @Override
    public String getProductURL(Product product){
        return product.getPicture() != null? "http://localhost:8080/product/photo/" + product.getId() : null;
    }

    @Override
    public ProductDTO createProductDTO(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName() != null? product.getName() : null)
                .price(product.getPrice() != null? product.getPrice() : null)
                .category(product.getCategory() != null? product.getCategory().getName() : null)
                .picture(getProductURL(product))
                .build();
    }
}
