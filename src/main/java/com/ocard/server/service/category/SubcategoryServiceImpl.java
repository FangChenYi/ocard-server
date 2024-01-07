package com.ocard.server.service.category;

import com.ocard.server.model.category.Subcategory;
import com.ocard.server.repository.category.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {
    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Override
    public List<Subcategory> getAllSubcategories() {
        return (List<Subcategory>) subcategoryRepository.findAll();
    }

    @Override
    public Object getSubcategoryById(Integer subcategoryId) {
        Optional<Subcategory> subcategoryResponse = subcategoryRepository.findById(subcategoryId);
        if (subcategoryResponse.isPresent()) {
            return subcategoryResponse.get();
        } else {
            return "Get method failed: SubcategoryId not found.";
        }
    }

    @Override
    public Subcategory createSubcategory(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public Object updateSubcategory(Integer subcategoryId, Subcategory subcategory) {
        Optional<Subcategory> subcategoryExisting = subcategoryRepository.findById(subcategoryId);
        if (subcategoryExisting.isPresent()) {
            subcategory.setSubcategoryId(subcategoryId);
            return subcategoryRepository.save(subcategory);
        } else {
            return "Update method failed: SubcategoryId not found.";
        }
    }

    @Override
    public String deleteSubcategory(Integer subcategoryId) {
        Optional<Subcategory> subcategoryExisting = subcategoryRepository.findById(subcategoryId);
        if (subcategoryExisting.isPresent()) {
            subcategoryRepository.deleteById(subcategoryId);
            return "Delete categoryId success.";
        } else {
            return "Delete method failed: SubcategoryId not found.";
        }
    }
}
