package com.tdtu.lihitiShop.repository.specification;

import com.tdtu.lihitiShop.entity.Product;
import org.springframework.data.jpa.domain.Specification;


public class ProductSpecifications {
    public static Specification<Product> withName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Product> withDescription(String description) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("description"), "%" + description + "%");
    }

    public static Specification<Product> withinPriceRange(Double minPrice, Double maxPrice) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
    }

    public static Specification<Product> withStockGreaterThan(Integer stockNumber) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("stock"), stockNumber);
    }

    public static Specification<Product> withOrigin(String origin) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("origin"), origin);
    }

    public static Specification<Product> withBrand(String brand) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("brand"), brand);
    }



    public static Specification<Product> withCategoryId(String categoryId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id_cate"), categoryId);
    }

    // Có thể thêm các tiêu chí tìm kiếm khác cho các trường như expiry_date, unit, brand, weight và origin ở đây tương tự...

    // Xây dựng một Specification tổng hợp các tiêu chí
    public static <LocalDate> Specification<Product> buildSpecification(
            String name, String description, Double minPrice, Double maxPrice, Integer stockNumber,
            String categoryId, String brand, String origin) {

        return Specification.where(withName(name))
                .and(withDescription(description))
                .and(withinPriceRange(minPrice, maxPrice))
                .and(withStockGreaterThan(stockNumber))
                .and(withCategoryId(categoryId))
                .and(withOrigin(origin))
                .and(withBrand(brand))

                ;
    }

}
