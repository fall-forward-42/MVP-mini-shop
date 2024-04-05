package com.tdtu.lihitiShop.mapper;

import com.tdtu.lihitiShop.dto.CategoryDto;
import com.tdtu.lihitiShop.dto.ProductDto;
import com.tdtu.lihitiShop.entity.Product;


public class ProductMapper {

    public static ProductDto mapToProductDto(Product product) {
        CategoryDto categoryDto = CategoryMapper.mapToCategoryDto(product.getCategory());
        return new ProductDto(
                product.getId_product(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getExpiry_date(),
                product.getUnit(),
                product.getBrand(),
                product.getWeight(),
                product.getOrigin(),
                product.getCreatedAt(),
                product.getUpdatedAt(),
                product.getImage(),
                CategoryMapper.mapToCategoryDto(product.getCategory())
        );
    }

    public static Product mapToProduct(ProductDto productDto) {

        Product product = new Product();

        product.setId_product(productDto.getId_product());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setExpiry_date(productDto.getExpiry_date());
        product.setUnit(productDto.getUnit());
        product.setBrand(productDto.getBrand());
        product.setWeight(productDto.getWeight());
        product.setOrigin(productDto.getOrigin());
        product.setCreatedAt(productDto.getCreatedAt());
        product.setUpdatedAt(productDto.getUpdatedAt());
        product.setImage(productDto.getImage());
        product.setCategory(CategoryMapper.mapToCategory(productDto.getCategory()));
        return product;

    }
}
        // Đối với trường hợp category, bạn cần set một thực thể Category, không phả
