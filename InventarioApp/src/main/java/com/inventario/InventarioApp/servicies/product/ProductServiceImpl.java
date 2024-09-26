package com.inventario.InventarioApp.servicies.product;

import com.inventario.InventarioApp.entities.Category;
import com.inventario.InventarioApp.entities.Product;
import com.inventario.InventarioApp.repositories.inventary.CategoryRepository;
import com.inventario.InventarioApp.repositories.inventary.ProductRepository;
import com.inventario.InventarioApp.utiles.ManageFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product addProduct(Product product, MultipartFile photo){
        Product newProduct = productRepository.save(product);
        if(newProduct.getCategory() != null){
            try {
                String photoPath = getDirectoryCategoryPhoto(product, photo);
                photo.transferTo(getDirectoryPhoto(photoPath));
                newProduct.setPicture(photoPath);
                productRepository.save(newProduct);
            } catch (IOException e) {
                throw new RuntimeException("Error al guardar la imagen.", e);
            }
        }
        return newProduct;
    }

    @Override
    public Product updateProductName(int id, String name) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(name);
                    return productRepository.save(product);
                })
                .orElse(null);
    }

    @Override
    public Product updateProductPrice(int id, float price){
        return productRepository.findById(id)
                .map(product -> {
                    product.setPrice(price);
                    return productRepository.save(product);
                })
                .orElse(null);
    }

    @Override
    public Product updatePhotoProduct(int id, MultipartFile newPhoto){
        Product product = productRepository.findById(id).orElse(null);
        if(product != null){
            File file = new File(product.getPicture());
            if(file.exists() && !file.delete()) throw new RuntimeException("Error al eliminar la imagen.");
            try {
                String photoPath = getDirectoryCategoryPhoto(product, newPhoto);
                newPhoto.transferTo(getDirectoryPhoto(photoPath));
                product.setPicture(photoPath);
                return productRepository.save(product);
            } catch (IOException e) {
                throw new RuntimeException("Error al guardar la imagen.", e);
            }
        }
        return null;
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(int idCategory) {
        Category category = categoryRepository.getReferenceById(idCategory);
        return productRepository.findAll().stream()
                .filter(product -> product.getCategory().getId().equals(category.getId()))
                .collect(Collectors.toList());
    }
}
