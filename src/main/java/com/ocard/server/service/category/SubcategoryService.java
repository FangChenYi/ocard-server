package com.ocard.server.service.category;

import com.ocard.server.model.category.Subcategory;

import java.util.List;

public interface SubcategoryService {
    List<Subcategory> getAllSubcategories();

    Object getSubcategoryById(Integer SubcategoryId);

    Subcategory createSubcategory(Subcategory subcategory);

    Object updateSubcategory(Integer SubcategoryId, Subcategory subcategory);

    String deleteSubcategory(Integer SubcategoryId);
}
