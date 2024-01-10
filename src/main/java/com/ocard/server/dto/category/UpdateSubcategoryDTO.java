package com.ocard.server.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSubcategoryDTO {

    @NotBlank
    private String subcategoryName;

}
