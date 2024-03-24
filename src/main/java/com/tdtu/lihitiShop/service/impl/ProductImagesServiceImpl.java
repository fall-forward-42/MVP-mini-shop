package com.tdtu.lihitiShop.service.impl;

import com.tdtu.lihitiShop.dto.ProductImagesDto;
import com.tdtu.lihitiShop.entity.Category;
import com.tdtu.lihitiShop.entity.Product;
import com.tdtu.lihitiShop.entity.ProductImages;
import com.tdtu.lihitiShop.exception.ResourceNotFoundException;
import com.tdtu.lihitiShop.mapper.ProductImagesMapper;
import com.tdtu.lihitiShop.mapper.ProductMapper;
import com.tdtu.lihitiShop.repository.ProductImagesRepository;
import com.tdtu.lihitiShop.repository.ProductRepository;
import com.tdtu.lihitiShop.service.ProductImagesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductImagesServiceImpl implements ProductImagesService {
    private ProductRepository productRepository;
    private ProductImagesRepository productImagesRepository;
    @Override
    public ProductImagesDto createImages(String id,ProductImagesDto productImagesDto) {
        //check exist category
        //String idP = productImagesDto.getProduct().getId_product();
        if(id==null){
            throw new ResourceNotFoundException("Please provide id product !");
        }
        Product p = productRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Not found product by id"+id));
        //convert DTO into entity

        ProductImages prepare = ProductImagesMapper.mapToProductImages(productImagesDto);
        prepare.setId_product(id);

        ProductImages savedProd = productImagesRepository.save(prepare);

        return ProductImagesMapper.mapToProductImagesDto(savedProd);
    }

    @Override
    public List<ProductImagesDto> getAllImagesById(String id) {
        if(id==null){
            throw new ResourceNotFoundException("Please provide id product !");
        }
        Product p = productRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Not found product by id"+id));


        List<ProductImagesDto> piList = productImagesRepository.findAll().stream()
                .filter(img -> img.getId_product().equals(id))
                .map(ProductImagesMapper::mapToProductImagesDto )
                .toList();

        return piList;
    }

    @Override
    public void deleteImage(String id) {
        ProductImages item = productImagesRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found image with ID: "+id));
        productImagesRepository.deleteById(id);
    }
}
