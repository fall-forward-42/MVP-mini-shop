package com.tdtu.lihitiShop.service.impl;

import com.tdtu.lihitiShop.dto.CategoryDto;
import com.tdtu.lihitiShop.dto.ProductDto;
import com.tdtu.lihitiShop.entity.Category;
import com.tdtu.lihitiShop.entity.Product;
import com.tdtu.lihitiShop.exception.ResourceNotFoundException;
import com.tdtu.lihitiShop.mapper.ProductMapper;
import com.tdtu.lihitiShop.repository.CategoryRepository;
import com.tdtu.lihitiShop.repository.ProductRepository;
import com.tdtu.lihitiShop.repository.specification.ProductSpecifications;
import com.tdtu.lihitiShop.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        //check exist category
        String idCate = productDto.getCategory().getId_cate();
        if(idCate==null){
            throw new  ResourceNotFoundException("Please provide category !");
        }
        Category category = categoryRepository.findById(idCate)
                .orElseThrow(()->new ResourceNotFoundException("Not found category by id"+idCate));
        //convert DTO into entity
        Product prod = ProductMapper.mapToProduct(productDto);

        Product savedProd = productRepository.save(prod);

        return ProductMapper.mapToProductDto(savedProd);

    }

    @Override
    public ProductDto getProductById(String idProd) {
        Product product = productRepository.findById(idProd)
                .orElseThrow(()-> new ResourceNotFoundException("Can't found the product with id: "+idProd));
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> prods =  productRepository.findAll();
        return prods.stream().map(ProductMapper::mapToProductDto
        ).collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(String idProd, ProductDto updateProdDto) {
        Product item = productRepository.findById(idProd)
                .orElseThrow(()-> new ResourceNotFoundException("Not found Product with ID: "+idProd));

       /* item.setName(updateProdDto.getName());
        item.setDescription(updateProdDto.getDescription());*/

        //...many properties
        modelMapper.map(updateProdDto,item);

        //save on DB
        Product updateObj = productRepository.save(item);

        return ProductMapper.mapToProductDto(updateObj);
    }

    @Override
    public List<ProductDto> getAllProductsByCate(CategoryDto categoryDto) {
        return productRepository.findAll().stream()
                .filter((m)->m.getCategory().getId_cate().equals(categoryDto.getId_cate()))
                .map(ProductMapper::mapToProductDto).toList();
    }

    @Override
    public List<ProductDto> getAllProductsByProductName(String name) {
        return productRepository.findAll().stream()
                .filter((m)->m.getName().toLowerCase().contains(name.toLowerCase()))
                .map(ProductMapper::mapToProductDto).toList();
    }

    @Override
    public List<ProductDto> getAllProductsByProductNameAndCategory(String name, CategoryDto categoryDto) {
        return productRepository.findAll().stream()
                .filter(m -> m.getName().toLowerCase().contains(name.toLowerCase())
                        && m.getCategory().getId_cate().equalsIgnoreCase(categoryDto.getId_cate()))
                .map(ProductMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(String idProd) {
        Product item = productRepository.findById(idProd)
                .orElseThrow(()-> new ResourceNotFoundException("Not found Product with ID: "+idProd));
        productRepository.deleteById(idProd);
    }

    @Override
    public List<ProductDto> searchProducts(
            String name, String description, Double minPrice, Double maxPrice, Integer stockNumber,
            String categoryId, String brand, String origin) {

        /*Specification<Product> spec = ProductSpecifications.buildSpecification(
                name, description, minPrice, maxPrice, stockNumber, categoryId, expiryDate, unit, brand, weight, origin);*/

        Specification<Product> specs = Specification.where(null);

        if (name != null) {
            specs = specs.and(ProductSpecifications.withName(name));
        }
        if (description != null) {
            specs = specs.and(ProductSpecifications.withDescription(description));
        }
        if (minPrice != null && minPrice > 0 ||maxPrice != null && maxPrice > 0  ) {
            specs = specs.and(ProductSpecifications.withinPriceRange(minPrice,maxPrice));
        }
        if (stockNumber != null) {
            specs = specs.and(ProductSpecifications.withStockGreaterThan(stockNumber));
        }
        if (categoryId != null) {
            specs = specs.and(ProductSpecifications.withCategoryId(categoryId));
        }
        if (brand != null) {
            specs = specs.and(ProductSpecifications.withName(brand));
        }
        if (origin != null) {
            specs = specs.and(ProductSpecifications.withOrigin(origin));
        }

        List<Product> products = productRepository.findAll(specs);
        return products.stream()
                .map(ProductMapper::mapToProductDto)
                .collect(Collectors.toList());
    }


}
