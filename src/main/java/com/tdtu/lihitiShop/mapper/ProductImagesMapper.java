package com.tdtu.lihitiShop.mapper;

import com.tdtu.lihitiShop.dto.CategoryDto;
import com.tdtu.lihitiShop.dto.ProductDto;
import com.tdtu.lihitiShop.dto.ProductImagesDto;
import com.tdtu.lihitiShop.entity.Product;
import com.tdtu.lihitiShop.entity.ProductImages;

public class ProductImagesMapper {
    public static ProductImagesDto mapToProductImagesDto(ProductImages img) {

        return new ProductImagesDto(
                img.getId_image(),
                img.getImageUrl(),
                img.getSortOrder(),
                img.getCreatedAt(),
                img.getUpdatedAt(),
                img.getId_product()
        );
    }

    public static ProductImages mapToProductImages(ProductImagesDto productImagesDto) {

        return new ProductImages(
                productImagesDto.getId_image(),
                productImagesDto.getImageUrl(),
                productImagesDto.getSortOrder(),
                productImagesDto.getCreatedAt(),
                productImagesDto.getUpdatedAt(),
                productImagesDto.getId_product()
        );

    }

}
