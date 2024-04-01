package com.tdtu.lihitiShop.mapper;

import com.tdtu.lihitiShop.dto.OrderDto;
import com.tdtu.lihitiShop.dto.OrderItemDto;
import com.tdtu.lihitiShop.entity.Order;

import java.util.List;
import java.util.Optional;

public class OrderMapper {

    public static OrderDto mapToDto(Order entity) {
        return new OrderDto(
              entity.getId_order(),
              UserMapper.mapToUserDto( entity.getUser()),
                entity.getOrderDate(),
                entity.getToltalPrice(),
                entity.getAddress(),
                entity.getStatus(),
                null
        );
    }
    public static OrderDto mapToDtoWithOrderItems(Order entity, List<OrderItemDto> items) {
        return new OrderDto(
                entity.getId_order(),
                UserMapper.mapToUserDto( entity.getUser()),
                entity.getOrderDate(),
                entity.getToltalPrice(),
                entity.getAddress(),
                entity.getStatus(),
                items
        );
    }

    public static Order mapToEntity(OrderDto dto) {
        return new Order(
                dto.getId_order(),
                UserMapper.mapToUser( dto.getUser()),
                dto.getOrderDate(),
                dto.getToltalPrice(),
                dto.getAddress(),
                dto.getStatus()
        );
    }


}
