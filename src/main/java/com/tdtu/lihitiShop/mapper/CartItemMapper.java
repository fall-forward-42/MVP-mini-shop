package com.tdtu.lihitiShop.mapper;

import com.tdtu.lihitiShop.config.convertDataTypeInterface;
import com.tdtu.lihitiShop.dto.CartDto;
import com.tdtu.lihitiShop.dto.CartItemDto;
import com.tdtu.lihitiShop.entity.CartItem;

public class CartItemMapper {

    public static CartItemDto mapToDto(CartItem entity) {
        return new CartItemDto(
                entity.getId_cart_item(),
                entity.getQuantity(),
                ProductMapper.mapToProductDto(entity.getProduct()),
                CartMapper.mapToDto(entity.getCart())
        );
    }

    public static CartItem mapToEntity(CartItemDto dto) {
        return new CartItem(
                dto.getId_cart_item(),
                dto.getQuantity(),
                ProductMapper.mapToProduct( dto.getProduct()),
                CartMapper.mapToEntity(dto.getCart())
        );
    }
}
