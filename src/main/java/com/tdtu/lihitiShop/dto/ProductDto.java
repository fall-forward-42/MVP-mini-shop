package com.tdtu.lihitiShop.dto;

import com.tdtu.lihitiShop.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
        private String id_product;
        private String name;
        private String description;
        private double price;
        private int stock;
        private Date expiry_date ;
        private String unit; // Đơn vị bán hàng (ví dụ: kg, gói, thùng, hộp, ...)
        private String brand;
        private double weight;
        private String origin;
        private  Date createdAt;
        private  Date updatedAt;
        private CategoryDto category;
}
