package com.inventario.InventarioApp.servicies.category;

import com.inventario.InventarioApp.entities.Category;
import com.inventario.InventarioApp.repositories.inventary.CategoryRepository;
import com.inventario.InventarioApp.utiles.ManageFile;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService, ManageFile {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        Category newCategory = categoryRepository.save(category);
        File categoryFile = new File(getPathFile("products" + File.separator + "categories" +
                File.separator + newCategory.getName()));
        if (!categoryFile.exists()) {
            if (!categoryFile.mkdirs()) throw new RuntimeException("No se creo el directorio " + category.getName());
        } else System.out.println("El directorio ya existe.");
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.findById(category.getId())
                .map(element -> {
                    String categoryFile = getCategoryDirectory(element.getName());
                    element.setName(category.getName());
                    if (! new File(categoryFile).renameTo(new File(getCategoryDirectory(element.getName()))))
                        throw new RuntimeException("No se actualizar el directorio " + element.getName());
                    return categoryRepository.save(element);
                })
                .orElse(null);
    }

    private String getCategoryDirectory(String category){
        return getPathFile("products" + File.separator + "categories" +
                File.separator + category);
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCategoryById(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            if(! new File(getCategoryDirectory(category.getName())).delete())
                throw new RuntimeException("No se elimino el directorio " + category.getName());
            else categoryRepository.findById(id).ifPresent(categoryRepository::delete);
        }
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
