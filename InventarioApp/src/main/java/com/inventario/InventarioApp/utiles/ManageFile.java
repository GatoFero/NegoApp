package com.inventario.InventarioApp.utiles;

import com.inventario.InventarioApp.entities.Product;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

public interface ManageFile {

    String DIRECTORY_PRODUCTS = "products";
    String DIRECTORY_CATEGORIES = "categories";
    String DIRECTORY_USERS = "users";

    default String getPathFile(String directory){
        return "C:" + File.separator + "NegoApp" + File.separator + "resources" + File.separator + directory;
    }

    default String setPathProductPhoto(Product product, MultipartFile photo) throws IOException {
        String fileName = comprobatePhoto(photo);
        if(fileName == null) return null;
        String picture = product.getId() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
        product.setPicture(picture);
        return getPathProductPhoto(product);
    }

    default String getPathProductPhoto(Product product) {
        return product.getCategory() != null?
                getPathFile(DIRECTORY_PRODUCTS) + File.separator + DIRECTORY_CATEGORIES +
                File.separator + product.getCategory().getName() + File.separator + product.getPicture() :
                getPathFile(DIRECTORY_PRODUCTS) + File.separator + product.getPicture();
    }

    default String comprobatePhoto(MultipartFile photo) {
        String fileName = photo.getOriginalFilename();
        if (fileName == null || !(fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".jpeg"))) {
            return null;
        }
        return fileName;
    }

    default void transferPhoto(MultipartFile photo, String path) throws IOException {
        File directory = new File(path).getParentFile();
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException("No se pudo crear el directorio " + directory.getPath());

        }
        File destination = new File(path);
        photo.transferTo(destination);
    }

    default void deletePhoto(String nameFile){
        File file = new File(nameFile);
        if(file.exists() && !file.delete()) throw new RuntimeException("Error al eliminar la imagen: " + file.getPath());
    }
}
