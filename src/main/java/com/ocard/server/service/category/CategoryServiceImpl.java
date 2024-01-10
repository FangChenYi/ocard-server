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
    public Category getCategoryById(Integer categoryId) {
        Optional<Category> categoryExisting = categoryRepository.findById(categoryId);
        if (categoryExisting.isPresent()) {
            return categoryExisting.get();
        } else {
            throw new NoSuchElementException("Get method failed: CategoryId not found.");
        }
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category=categoryMapper.CategoryDTOtoCategory(categoryDTO);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Integer categoryId,
                                   CategoryDTO categoryDTO) {
        Optional<Category> categoryExisting = categoryRepository.findById(categoryId);
        if (categoryExisting.isPresent()) {
            Category category= categoryMapper.CategoryDTOtoCategory(categoryDTO);
            category.setCategoryId(categoryId);
            return categoryRepository.save(category);
        } else {
            throw new NoSuchElementException("Update method failed: CategoryId not found.");
        }
    }

    @Override
    public String deleteCategory(Integer categoryId) {
        Optional<Category> categoryExisting = categoryRepository.findById(categoryId);
        if (categoryExisting.isPresent()) {
            categoryRepository.deleteById(categoryId);
            return "Delete categoryId success.";
        } else {
            throw new NoSuchElementException("Delete method failed: CategoryId not found.");
        }
    }
}
