package com.tdtu.lihitiShop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private String id_order_item;

    private String id_product;

    private OrderDto order;

    private Integer quantity;

    private Double price;
}
