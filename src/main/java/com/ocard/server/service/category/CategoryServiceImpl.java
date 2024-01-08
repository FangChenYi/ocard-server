package com.ocard.server.service.category;

import com.ocard.server.model.category.Category;
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


    @Override
    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        Optional<Category> categoryResponse = categoryRepository.findById(categoryId);
        if (categoryResponse.isPresent()) {
            return categoryResponse.get();
        } else {
            throw new NoSuchElementException("Get method failed: CategoryId not found.");
        }
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Integer categoryId,
                                 Category category) {
        Optional<Category> categoryExisting = categoryRepository.findById(categoryId);
        if (categoryExisting.isPresent()) {
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
            return "Delete method failed: CategoryId not found.";
        }
    }
}
