package com.tdtu.lihitiShop;

import com.tdtu.lihitiShop.dto.CategoryDto;
import com.tdtu.lihitiShop.entity.Category;
import com.tdtu.lihitiShop.mapper.CategoryMapper;
import com.tdtu.lihitiShop.repository.CategoryRepository;
import com.tdtu.lihitiShop.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CategoryTest {
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void addCate(){
        Category cate = new Category();
        cate.setName("Do an nhanh");
        cate.setDescription(("An rat ngon"));

        when(categoryRepository.save(cate)).thenReturn(cate);

        CategoryDto saved = categoryService.createCate(CategoryMapper.mapToCategoryDto(cate));

        assertEquals(cate.getName(),saved.getName());
        assertEquals(cate.getDescription(),saved.getDescription());

        verify(categoryRepository,times(1)).save(cate);

    }
}
