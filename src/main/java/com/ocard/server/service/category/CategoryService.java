package com.ocard.server.service.category;

import com.ocard.server.model.category.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Object getCategoryById(Integer categoryId);

    Category createCategory(Category category);

    Object updateCategory(Integer categoryId, Category category);

    String deleteCategory(Integer categoryId);
}
