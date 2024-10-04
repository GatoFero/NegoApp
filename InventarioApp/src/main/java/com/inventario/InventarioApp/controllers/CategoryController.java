package com.inventario.InventarioApp.controllers;

import com.inventario.InventarioApp.DTOS.CategoryDTO;
import com.inventario.InventarioApp.entities.Category;
import com.inventario.InventarioApp.servicies.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable int id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build());
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updateCategory(@PathVariable int id, @RequestBody String name) {
//        Category category = categoryService .updateCategory(id, name);
//        if (category == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return ResponseEntity.ok(CategoryDTO.builder()
//                .id(category.getId())
//                .name(category.getName())
//                .build());
//    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok("Category eliminada");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build())
                .collect(Collectors.toList()));
    }
}
