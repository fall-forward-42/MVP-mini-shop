package com.tdtu.lihitiShop.mapper;

import com.tdtu.lihitiShop.config.convertDataTypeInterface;
import com.tdtu.lihitiShop.dto.CartDto;
import com.tdtu.lihitiShop.dto.CartItemDto;
import com.tdtu.lihitiShop.entity.Cart;
import com.tdtu.lihitiShop.entity.CartItem;

import java.util.Set;
import java.util.stream.Collectors;

public class CartMapper  {

    public static CartDto mapToDto(Cart entity) {
        return new CartDto(
                entity.getId_cart(),
                entity.getId_user(),
                entity.getCreatedAt()
        );
    }

    public static Cart mapToEntity(CartDto dto) {
        return new Cart(
                dto.getId_cart(),
                dto.getId_user(),
                dto.getCreatedAt()
        );
    }
}


