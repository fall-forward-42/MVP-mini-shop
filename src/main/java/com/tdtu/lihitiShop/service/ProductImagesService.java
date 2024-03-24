package com.tdtu.lihitiShop.service;

import com.tdtu.lihitiShop.dto.ProductImagesDto;
import com.tdtu.lihitiShop.entity.ProductImages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductImagesService {
    ProductImagesDto createImages(String id,ProductImagesDto productImagesDto);

    List<ProductImagesDto> getAllImagesById(String id);

    void deleteImage(String id);
}
