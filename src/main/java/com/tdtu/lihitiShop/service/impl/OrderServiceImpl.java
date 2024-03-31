package com.tdtu.lihitiShop.service.impl;

import com.tdtu.lihitiShop.dto.OrderDto;
import com.tdtu.lihitiShop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class
OrderServiceImpl implements OrderService {

    @Override
    public OrderDto createOrder(String idUser, Double totalPrice, String address) {
        return null;
    }

    @Override
    public OrderDto confirmOrderByStaff(String idOrder) {
        return null;
    }

    @Override
    public OrderDto confirmOrderByCustomer(String idOrder) {
        return null;
    }

    @Override
    public OrderDto cancelOrder(String idOrder) {
        return null;
    }
}
