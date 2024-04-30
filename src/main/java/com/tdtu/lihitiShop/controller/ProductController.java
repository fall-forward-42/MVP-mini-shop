package com.tdtu.lihitiShop.controller;

import com.tdtu.lihitiShop.dto.CategoryDto;
import com.tdtu.lihitiShop.dto.ProductDto;
import com.tdtu.lihitiShop.dto.ProductImagesDto;
import com.tdtu.lihitiShop.service.ProductImagesService;
import com.tdtu.lihitiShop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/products")
public class ProductController {
    private ProductService productService;

    private ProductImagesService productImagesService;

    @PostMapping("/search-by-category")
    public ResponseEntity<List<ProductDto>> searchProductsByCate(@RequestBody CategoryDto categoryDto){
        List<ProductDto> result = productService.getAllProductsByCate(categoryDto);
        return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
    }
    @PostMapping("/search-by-name")
    public ResponseEntity<List<ProductDto>> searchProductsByName(@RequestBody String productName){
        List<ProductDto> result = productService.getAllProductsByProductName(productName);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }
    @PostMapping("/search-by-name-and-category")
    public ResponseEntity<List<ProductDto>> searchProductsByNameAndCate(@RequestBody String productName,@RequestBody CategoryDto categoryDto){
        List<ProductDto> result = productService.getAllProductsByProductNameAndCategory(productName,categoryDto);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }

    @PostMapping("{id}/image")
    public ResponseEntity<ProductImagesDto> createImageForProduct(@PathVariable("id") String id
            ,@RequestBody ProductImagesDto imagesDto){
        ProductImagesDto savedImage = productImagesService.createImages(id,imagesDto);

        return new ResponseEntity<>(savedImage,HttpStatus.CREATED);
    }
    @GetMapping("{id}/images")
    public ResponseEntity<List<ProductImagesDto>> getImagesByProductId(@PathVariable("id") String id){
        List<ProductImagesDto> ipList = productImagesService.getAllImagesById(id);
        return ResponseEntity.ok(ipList);
    }

    @DeleteMapping("image/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable("id") String id
    ){
        productImagesService.deleteImage(id);
        return ResponseEntity.ok("Delete successfully !");
    }


    @PostMapping
    public ResponseEntity<ProductDto> createProduct(
            @RequestBody ProductDto productDto){
        ProductDto savedProd = productService.createProduct(productDto);
        return new ResponseEntity<>(savedProd, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProd(@PathVariable("id") String id){
        ProductDto ProductDto = productService.getProductById(id);
        return ResponseEntity.ok(ProductDto);
    }
    //get all prods
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllPro(){
        List<ProductDto> items = productService.getAllProducts();
        return ResponseEntity.ok(items);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updatePro(@PathVariable("id") String id,
                                                  @RequestBody ProductDto updateCateDto
    ){
        ProductDto itemDto = productService.updateProduct(id,updateCateDto);
        return ResponseEntity.ok(itemDto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePro(@PathVariable("id") String id
    ){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Delete successfully !");
    }

    
}
