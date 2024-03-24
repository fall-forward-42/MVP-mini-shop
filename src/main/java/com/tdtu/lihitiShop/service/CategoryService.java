package com.tdtu.lihitiShop.service;

import com.tdtu.lihitiShop.dto.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryDto createCate(CategoryDto categoryDto);
    CategoryDto getCateById(String idCate);
    List<CategoryDto> getAllCates();

    CategoryDto updateCate(String idCate, CategoryDto updateCateDto);
    void deleteCate(String idCate);

}
