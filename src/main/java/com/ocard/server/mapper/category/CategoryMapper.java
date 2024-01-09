package com.ocard.server.mapper.category;

import com.ocard.server.model.category.Category;
import com.ocard.server.model.category.CategoryDTO;
import com.ocard.server.model.category.Subcategory;
import com.ocard.server.model.category.SubcategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category CategoryDTOtoCategory(CategoryDTO categoryDTO);

    Subcategory SubcategoryDTOtoSubcategory(SubcategoryDTO subcategoryDTO);
}
