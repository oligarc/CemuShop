package com.oligarc.online_shop.service;

import com.oligarc.online_shop.DTO.CategoryDTO;
import com.oligarc.online_shop.model.Category;

import java.util.List;

public interface ServiceCategory {
    public List<CategoryDTO> getAllCategories();
    public CategoryDTO getCategoryById(int id);
    public CategoryDTO addCategory(Category category);
    public CategoryDTO updateCategory(Category category, int id);
    public void deleteCategory(int id);
}
