package com.inventario.InventarioApp.servicies.category;

import com.inventario.InventarioApp.entities.Category;
import com.inventario.InventarioApp.repositories.inventary.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public Category getCategoryById(int id) {
        return null;
    }

    @Override
    public void deleteCategoryById(int id) {

    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }
}
