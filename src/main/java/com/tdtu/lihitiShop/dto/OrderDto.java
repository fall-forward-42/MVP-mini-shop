package com.tdtu.lihitiShop.dto;

import com.tdtu.lihitiShop.entity.OrderItem;
import com.tdtu.lihitiShop.entity.User;
import com.tdtu.lihitiShop.entity.enumType.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private String id_order;

    private UserDto user;

    private Date orderDate;

    private Double toltalPrice;

    private String address;

    private OrderStatus status;

}
