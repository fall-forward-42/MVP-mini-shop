package com.tdtu.lihitiShop.service;

import com.tdtu.lihitiShop.dto.CategoryDto;
import com.tdtu.lihitiShop.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto getProductById(String idProd);
    List<ProductDto> getAllProducts();
    ProductDto updateProduct(String idProd, ProductDto updateProdDto);

    List<ProductDto> getAllProductsByCate(CategoryDto categoryDto);

    List<ProductDto> getAllProductsByProductName(String name);


    List<ProductDto> getAllProductsByProductNameAndCategory(String name, CategoryDto categoryDto);

    void deleteProduct(String idProd);

    List<ProductDto> searchProducts(
            String name, String description, Double minPrice, Double maxPrice, Integer stockNumber,
            String categoryId, String brand, String origin);
}
