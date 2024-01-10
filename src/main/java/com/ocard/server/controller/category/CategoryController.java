package com.ocard.server.controller.category;

import com.ocard.server.model.category.Category;
import com.ocard.server.dto.category.CategoryDTO;
import com.ocard.server.service.category.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/{categoryId}")
    public Category getCategoryById(@PathVariable Integer categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("/category")
    public Category createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    @PutMapping("/category/{categoryId}")
    public Category updateCategory(@PathVariable Integer categoryId,
                      @RequestBody @Valid CategoryDTO categoryDTO) {
        return categoryService.updateCategory(categoryId, categoryDTO);
    }

    @DeleteMapping("/category/{categoryId}")
    public String deleteCategory(@PathVariable Integer categoryId) {
       return categoryService.deleteCategory(categoryId);
    }
}
