package com.ocard.server.repository.category;

import com.ocard.server.model.category.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
