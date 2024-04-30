package com.tdtu.lihitiShop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tdtu.lihitiShop.dto.CategoryDto;
import com.tdtu.lihitiShop.entity.Category;
import com.tdtu.lihitiShop.mapper.CategoryMapper;
import com.tdtu.lihitiShop.repository.CategoryRepository;
import com.tdtu.lihitiShop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
@AllArgsConstructor
class LihitiShopApplicationTests {

	MockMvc mockMvc;
	ObjectMapper objectMapper;
	@MockBean
	CategoryRepository categoryRepository;
	CategoryService categoryService;

	@Test
	public void createCate_success() throws Exception {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setName("Test Category");

		Category category = CategoryMapper.mapToCategory(categoryDto);
		category.setId_cate(UUID.randomUUID().toString());

		Mockito.when(categoryRepository.save(category)).thenReturn(category);
		Mockito.when(CategoryMapper.mapToCategoryDto(category)).thenReturn(categoryDto);

		CategoryDto savedCategoryDto = categoryService.createCate(categoryDto);

		Assertions.assertThat(savedCategoryDto).isNotNull();
		Assertions.assertThat(savedCategoryDto.getName()).isEqualTo(categoryDto.getName());
	}







}
