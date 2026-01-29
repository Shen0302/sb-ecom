package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServicelmpl implements CategoryService {

    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public void createCategory(Category category) {
        categories.add(category);

    }
}
