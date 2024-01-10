package com.ocard.server.service.category;

import com.ocard.server.model.category.Category;
import com.ocard.server.dto.category.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(Integer categoryId);

    Category createCategory(CategoryDTO categoryDTO);

    Category updateCategory(Integer categoryId, CategoryDTO categoryDTO);

    String deleteCategory(Integer categoryId);
}
