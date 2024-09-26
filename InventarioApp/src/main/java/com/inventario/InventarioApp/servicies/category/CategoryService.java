package com.inventario.InventarioApp.servicies.category;

import com.inventario.InventarioApp.entities.Category;

import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);
    Category updateCategory(Integer id, String name);
    Category getCategoryById(int id);
    void deleteCategoryById(int id);
    List<Category> getAllCategories();
}
