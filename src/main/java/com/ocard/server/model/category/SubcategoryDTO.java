package com.ocard.server.model.category;

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
