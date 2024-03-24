package com.tdtu.lihitiShop.mapper;

import com.tdtu.lihitiShop.dto.CartItemDto;
import com.tdtu.lihitiShop.dto.OrderItemDto;
import com.tdtu.lihitiShop.entity.CartItem;
import com.tdtu.lihitiShop.entity.OrderItem;

public class OrderItemMapper {
    public OrderItemDto mapToDto(OrderItem entity) {
        return new OrderItemDto(
                entity.getId_order_item(),
                ProductMapper.mapToProductDto(entity.getProduct()),
                OrderMapper.mapToDto( entity.getOrder()),
                entity.getQuantity(),
                entity.getPrice()
        );
    }

    public OrderItem mapToEntity(OrderItemDto dto) {
        return new OrderItem(
                dto.getId_order_item(),
                ProductMapper.mapToProduct(dto.getProduct()),
                OrderMapper.mapToEntity( dto.getOrder()),
                dto.getQuantity(),
                dto.getPrice()
        );
    }
}
