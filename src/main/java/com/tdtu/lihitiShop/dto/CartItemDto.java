package com.tdtu.lihitiShop.dto;

import com.tdtu.lihitiShop.entity.Cart;
import com.tdtu.lihitiShop.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private String id_cart_item;

    private Integer quantity;

    private ProductDto product;

    private CartDto cart;
}
