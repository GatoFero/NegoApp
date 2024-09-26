package com.inventario.InventarioApp.utiles;

import com.inventario.InventarioApp.entities.Category;
import com.inventario.InventarioApp.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;

public interface ManageFile {

    default String getCategoryPath(String nameCategory){
        return "InventarioApp"+ File.separator + "src" + File.separator + "main" + File.separator + "resources" +File.separator +
                "product" + File.separator + "categories" + File.separator + nameCategory;
    }

    default String getDirectoryCategoryPhoto(Product product, MultipartFile photo){
        Category category = product.getCategory();
        String[] photoName = Objects.requireNonNull(photo.getOriginalFilename()).split("\\.");
        String extension = photoName[photoName.length - 1];
        return category.getDirectoryFile()
                + File.separator + product.getId() + "." + extension;
    }

    default File getDirectoryPhoto(String photoPath){
        return new File(photoPath);
    }
}
