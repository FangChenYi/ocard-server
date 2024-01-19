package com.ocard.server.service.category;

import com.ocard.server.mapper.category.CategoryMapper;
import com.ocard.server.model.category.Category;
import com.ocard.server.dto.category.CategoryDTO;
import com.ocard.server.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer categoryId) throws NoSuchElementException {
        Optional<Category> categoryExisting = categoryRepository.findById(categoryId);
        return categoryExisting.get();
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.categoryDTOtoCategory(categoryDTO);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Integer categoryId,
                                   CategoryDTO categoryDTO) throws NoSuchElementException {
        Category category = categoryMapper.categoryDTOtoCategory(categoryDTO);
        category.setCategoryId(categoryId);
        return categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Integer categoryId) throws NoSuchElementException {
        Optional<Category> categoryExisting = categoryRepository.findById(categoryId);
        categoryRepository.deleteById(categoryExisting.get().getCategoryId());
        return "Delete categoryId success.";
    }
}
