package com.ocard.server.controller.category;

import com.ocard.server.dto.category.UpdateSubcategoryDTO;
import com.ocard.server.model.category.Subcategory;
import com.ocard.server.dto.category.SubcategoryDTO;
import com.ocard.server.service.category.SubcategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubcategoryController {
    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping("/subcategory")
    public List<Subcategory> getAllSubcategories() {
        return subcategoryService.getAllSubcategories();
    }

    @GetMapping("/subcategory/{subcategoryId}")
    public Subcategory getSubcategoryById(@PathVariable Integer subcategoryId) {
        return subcategoryService.getSubcategoryById(subcategoryId);
    }

    @PostMapping("/subcategory")
    public Subcategory createSubcategory(@RequestBody @Valid SubcategoryDTO subcategoryDTO) {
        return subcategoryService.createSubcategory(subcategoryDTO);
    }

    @PutMapping("/subcategory/{subcategoryId}")
    public Subcategory updateSubcategory(@PathVariable Integer subcategoryId,
                                         @RequestBody @Valid UpdateSubcategoryDTO updateSubcategoryDTO) {
        return subcategoryService.updateSubcategory(subcategoryId, updateSubcategoryDTO);
    }

    @DeleteMapping("/subcategory/{subcategoryId}")
    public String deleteSubcategory(@PathVariable Integer subcategoryId) {
        return subcategoryService.deleteSubcategory(subcategoryId);
    }
}
