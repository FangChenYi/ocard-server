package com.ocard.server.service.category;

import com.ocard.server.model.category.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(Integer categoryId);

    Category createCategory(Category category);

    Category updateCategory(Integer categoryId, Category category);

    String deleteCategory(Integer categoryId);
}
