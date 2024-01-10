package com.ocard.server.service.category;

import com.ocard.server.dto.category.UpdateSubcategoryDTO;
import com.ocard.server.model.category.Subcategory;
import com.ocard.server.dto.category.SubcategoryDTO;

import java.util.List;

public interface SubcategoryService {
    List<Subcategory> getAllSubcategories();

    Subcategory getSubcategoryById(Integer SubcategoryId);

    Subcategory createSubcategory(SubcategoryDTO subcategoryDTO);

    Subcategory updateSubcategory(Integer SubcategoryId, UpdateSubcategoryDTO updateSubcategoryDTO);

    String deleteSubcategory(Integer SubcategoryId);
}
