package com.tdtu.lihitiShop.service.impl;

import com.tdtu.lihitiShop.dto.CategoryDto;
import com.tdtu.lihitiShop.entity.Category;
import com.tdtu.lihitiShop.exception.ResourceNotFoundException;
import com.tdtu.lihitiShop.mapper.CategoryMapper;
import com.tdtu.lihitiShop.repository.CategoryRepository;
import com.tdtu.lihitiShop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    @Override
    public CategoryDto createCate(CategoryDto categoryDto) {
        //convert DTO into entity and save to repository
        Category cate = CategoryMapper.mapToCategory(categoryDto);
        cate.setId_cate(UUID.randomUUID().toString());
        Category savedCate = categoryRepository.save(cate);
        return CategoryMapper.mapToCategoryDto(savedCate);
    }
    @Override
    public CategoryDto getCateById(String idCate) {
        //find cate in DB and return cateDTO or throw exception
        Category cate = categoryRepository.findById(idCate)
                .orElseThrow(()-> new ResourceNotFoundException("Can't found the category with id: "+idCate));
        return CategoryMapper.mapToCategoryDto(cate);
    }

    @Override
    public List<CategoryDto> getAllCates() {
        List<Category> cates =  categoryRepository.findAll();
        return cates.stream().map(CategoryMapper::mapToCategoryDto
        ).collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCate(String idCate, CategoryDto updateCateDto) {
        //find cate
        Category cate = categoryRepository.findById(idCate)
                .orElseThrow(()-> new ResourceNotFoundException("Not found Category with ID: "+idCate));

        //update cate
        cate.setName(updateCateDto.getName());
        cate.setDescription(updateCateDto.getDescription());

        //save on DB
        Category updateCateObj = categoryRepository.save(cate);

        return CategoryMapper.mapToCategoryDto(updateCateObj);
    }

    @Override
    public void deleteCate(String idCate) {
        //find cate
        Category cate = categoryRepository.findById(idCate)
                .orElseThrow(()-> new ResourceNotFoundException("Not found Category with ID: "+idCate));
        categoryRepository.deleteById(idCate);
    }
}
