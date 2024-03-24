package com.tdtu.lihitiShop.controller;

import com.tdtu.lihitiShop.dto.CategoryDto;
import com.tdtu.lihitiShop.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;
    //REST API
    @PostMapping
    public ResponseEntity<CategoryDto> createCate(@RequestBody CategoryDto categoryDto){
        CategoryDto savedCate =categoryService.createCate(categoryDto);
        return new ResponseEntity<>(savedCate, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCate(@PathVariable("id") String idCate){
        CategoryDto categoryDto = categoryService.getCateById(idCate);
        return ResponseEntity.ok(categoryDto);
    }
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCate(){
        List<CategoryDto> cates = categoryService.getAllCates();
        return ResponseEntity.ok(cates);
    }
    @PutMapping("{id}")
        public ResponseEntity<CategoryDto> updateCate(@PathVariable("id") String idCate,
            @RequestBody CategoryDto updateCateDto
        ){
            CategoryDto cateDto = categoryService.updateCate(idCate,updateCateDto);
            return ResponseEntity.ok(cateDto);
        }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCate(@PathVariable("id") String idCate
    ){
        categoryService.deleteCate(idCate);
        return ResponseEntity.ok("Delete successfully !");
    }

}
