package com.oligarc.online_shop.service;

import com.oligarc.online_shop.DTO.CategoryDTO;
import com.oligarc.online_shop.exceptions.CategoryNotFoundException;
import com.oligarc.online_shop.mappers.CategoryMapper;
import com.oligarc.online_shop.model.Category;
import com.oligarc.online_shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServiceCategoryImpl implements ServiceCategory{

    private CategoryRepository categoryRepository;

    @Autowired
    public ServiceCategoryImpl(CategoryRepository v_categoryRepository){
        this.categoryRepository=v_categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::convertToCategoryDTO)
                .toList();
    }

    @Override
    public CategoryDTO getCategoryById(int id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("No existe una categoría con ese id"));
        return CategoryMapper.convertToCategoryDTO(category);
    }

    @Transactional
    @Override
    public CategoryDTO addCategory(Category category) {
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.convertToCategoryDTO(savedCategory);
    }

    @Transactional
    @Override
    public CategoryDTO updateCategory(Category category, int id) {
        Category categoryUpdated = categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("No existe una categoría con ese id"));
        categoryUpdated.setName(category.getName());
        categoryRepository.save(categoryUpdated);
        return CategoryMapper.convertToCategoryDTO(categoryUpdated);
    }

    @Transactional
    @Override
    public void deleteCategory(int id) {
        Category categoryToDelete = categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("No existe una categoría con ese id"));
        categoryRepository.delete(categoryToDelete);

    }
}
