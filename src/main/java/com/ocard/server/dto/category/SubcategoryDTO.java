package com.ocard.server.dto.category;

import com.ocard.server.model.category.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubcategoryDTO {
    @NotBlank
    private String subcategoryName;

    private Category category;
}
