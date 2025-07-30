package com.oligarc.online_shop.mappers;

import com.oligarc.online_shop.DTO.CategoryDTO;
import com.oligarc.online_shop.model.Category;

public class CategoryMapper {

    public static CategoryDTO convertToCategoryDTO(Category category){
        return new CategoryDTO(category.getId(), category.getName());
    }
}
