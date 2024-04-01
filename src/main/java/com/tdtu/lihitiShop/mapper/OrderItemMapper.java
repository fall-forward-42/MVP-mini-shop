package com.tdtu.lihitiShop.mapper;

import com.tdtu.lihitiShop.dto.CartItemDto;
import com.tdtu.lihitiShop.dto.OrderItemDto;
import com.tdtu.lihitiShop.dto.ProductDto;
import com.tdtu.lihitiShop.entity.CartItem;
import com.tdtu.lihitiShop.entity.OrderItem;

public class OrderItemMapper {
    public static OrderItemDto mapToDto(OrderItem entity) {
        return new OrderItemDto(
                entity.getId_order_item(),
                entity.getId_product(),
                OrderMapper.mapToDto( entity.getOrder()),
                entity.getQuantity(),
                entity.getPrice(),
                null
        );
    }
    public static OrderItemDto mapToDtoWithProduct(OrderItem entity, ProductDto productDto) {
        return new OrderItemDto(
                entity.getId_order_item(),
                entity.getId_product(),
                OrderMapper.mapToDto( entity.getOrder()),
                entity.getQuantity(),
                entity.getPrice(),
                productDto
        );
    }

    public static OrderItem mapToEntity(OrderItemDto dto) {
        return new OrderItem(
                dto.getId_order_item(),
                dto.getId_product(),
                OrderMapper.mapToEntity( dto.getOrder()),
                dto.getQuantity(),
                dto.getPrice()
        );
    }
}
