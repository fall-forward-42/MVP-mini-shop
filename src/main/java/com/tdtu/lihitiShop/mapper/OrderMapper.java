package com.tdtu.lihitiShop.mapper;

import com.tdtu.lihitiShop.dto.OrderDto;
import com.tdtu.lihitiShop.entity.Order;

public class OrderMapper {

    public static OrderDto mapToDto(Order entity) {
        return new OrderDto(
              entity.getId_order(),
              UserMapper.mapToUserDto( entity.getUser()),
                entity.getOrderDate(),
                entity.getToltalPrice(),
                entity.getAddress(),
                entity.getStatus()


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
