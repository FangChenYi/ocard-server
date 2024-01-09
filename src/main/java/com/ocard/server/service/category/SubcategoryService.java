package com.ocard.server.service.category;

import com.ocard.server.model.category.Subcategory;
import com.ocard.server.model.category.SubcategoryDTO;

import java.util.List;

public interface SubcategoryService {
    List<Subcategory> getAllSubcategories();

    Subcategory getSubcategoryById(Integer SubcategoryId);

    Subcategory createSubcategory(SubcategoryDTO subcategoryDTO);

    Subcategory updateSubcategory(Integer SubcategoryId, SubcategoryDTO subcategoryDTO);

    String deleteSubcategory(Integer SubcategoryId);
}
