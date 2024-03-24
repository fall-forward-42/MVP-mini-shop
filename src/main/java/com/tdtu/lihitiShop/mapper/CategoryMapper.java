package com.tdtu.lihitiShop.mapper;

import com.tdtu.lihitiShop.dto.CategoryDto;
import com.tdtu.lihitiShop.entity.Category;
import com.tdtu.lihitiShop.entity.Product;

import java.util.Set;

public class CategoryMapper {
    public static CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(
                category.getId_cate(),
                category.getName(),
                category.getDescription()
        );
    }
    public static Category mapToCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.getId_cate(),
                categoryDto.getName(),
                categoryDto.getDescription()
        );
    }

}
