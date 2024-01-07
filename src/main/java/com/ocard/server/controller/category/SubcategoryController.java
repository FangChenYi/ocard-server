package com.ocard.server.controller.category;

import com.ocard.server.model.category.Subcategory;
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
    public Object getSubcategoryById(@PathVariable Integer subcategoryId) {
        return subcategoryService.getSubcategoryById(subcategoryId);
    }

    @PostMapping("/subcategory")
    public Object createSubcategory(@RequestBody @Valid Subcategory subcategory) {
        return subcategoryService.createSubcategory(subcategory);
    }

    @PutMapping("/subcategory/{subcategoryId}")
    public Object updateSubcategory(@PathVariable Integer subcategoryId,
                                 @RequestBody @Valid Subcategory subcategory) {
        return subcategoryService.updateSubcategory(subcategoryId, subcategory);
    }

    @DeleteMapping("/subcategory/{subcategoryId}")
    public String deleteSubcategory(@PathVariable Integer subcategoryId) {
        return subcategoryService.deleteSubcategory(subcategoryId);
    }
}
