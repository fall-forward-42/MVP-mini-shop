package com.tdtu.lihitiShop.dto;

import com.tdtu.lihitiShop.entity.Product;
import com.tdtu.lihitiShop.entity.ProductImages;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImagesDto {
    private String id_image;
    private String imageUrl;
    private int sortOrder;
    private Date createdAt;
    private Date updatedAt;
    private String id_product;


}
