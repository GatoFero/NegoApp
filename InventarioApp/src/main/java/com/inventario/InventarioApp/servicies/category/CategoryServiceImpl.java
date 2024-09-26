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
        File categoryFile = new File(getCategoryPath(newCategory.getName()));
        if (!categoryFile.exists()) {
            if (!categoryFile.mkdirs()) throw new RuntimeException("No se creo el directorio " + category.getName());
        } else System.out.println("El directorio ya existe.");
        return newCategory;
    }

    @Override
    public Category updateCategory(Integer id, String name) {
        return categoryRepository.findById(id)
                .map(category -> {
                    if (! new File(getCategoryPath(category.getName())).renameTo(new File(getCategoryPath(name))))
                        throw new RuntimeException("No se actualizar el directorio " + category.getName());
                    category.setName(name);
                    return categoryRepository.save(category);
                })
                .orElse(null);
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCategoryById(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            if(! new File(getCategoryPath(category.getName())).delete())
                throw new RuntimeException("No se elimino el directorio " + category.getName());
            else categoryRepository.findById(id).ifPresent(categoryRepository::delete);
        }
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
