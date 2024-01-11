package com.ocard.server.service.category;

import com.ocard.server.dto.category.UpdateSubcategoryDTO;
import com.ocard.server.mapper.category.CategoryMapper;
import com.ocard.server.model.category.Subcategory;
import com.ocard.server.dto.category.SubcategoryDTO;
import com.ocard.server.repository.category.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {
    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Subcategory> getAllSubcategories() {
        return (List<Subcategory>) subcategoryRepository.findAll();
    }

    @Override
    public Subcategory getSubcategoryById(Integer subcategoryId) throws NoSuchElementException {
        Optional<Subcategory> subcategoryExisting = subcategoryRepository.findById(subcategoryId);
        return subcategoryExisting.get();
    }

    @Override
    public Subcategory createSubcategory(SubcategoryDTO subcategoryDTO) {
        Subcategory subcategory = categoryMapper.SubcategoryDTOtoSubcategory(subcategoryDTO);
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public Subcategory updateSubcategory(Integer subcategoryId,
                                         UpdateSubcategoryDTO updateSubcategoryDTO) throws NoSuchElementException {
        Optional<Subcategory> subcategoryExisting = subcategoryRepository.findById(subcategoryId);
        Subcategory subcategory = categoryMapper.UpdateSubcategoryDTOtoSubcategory(updateSubcategoryDTO);
        subcategory.setCategory(subcategoryExisting.get().getCategory());
        subcategory.setSubcategoryId(subcategoryId);
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public String deleteSubcategory(Integer subcategoryId) throws NoSuchElementException {
        Optional<Subcategory> subcategoryExisting = subcategoryRepository.findById(subcategoryId);
        subcategoryRepository.deleteById(subcategoryExisting.get().getSubcategoryId());
        return "Delete categoryId success.";
    }
}
