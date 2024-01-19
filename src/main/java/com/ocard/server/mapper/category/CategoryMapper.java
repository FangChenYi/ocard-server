package com.ocard.server.mapper.category;

import com.ocard.server.dto.category.UpdateSubcategoryDTO;
import com.ocard.server.model.category.Category;
import com.ocard.server.dto.category.CategoryDTO;
import com.ocard.server.model.category.Subcategory;
import com.ocard.server.dto.category.SubcategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category categoryDTOtoCategory(CategoryDTO categoryDTO);

    Subcategory subcategoryDTOtoSubcategory(SubcategoryDTO subcategoryDTO);

    Subcategory updateSubcategoryDTOtoSubcategory(UpdateSubcategoryDTO updateSubcategoryDTO);
}
