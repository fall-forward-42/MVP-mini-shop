package com.tdtu.lihitiShop.service;

import com.tdtu.lihitiShop.dto.OrderDto;
import com.tdtu.lihitiShop.dto.OrderItemDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrderService {
    public OrderDto createOrder(String idUser, Double totalPrice, String address );//status NEW

    public OrderDto confirmOrderByStaff(String idOrder);//status shipped

    public OrderDto confirmOrderByCustomer(String idOrder);//status delivered

    public OrderDto cancelOrder(String idOrder);//status cancelled


    public List<OrderItemDto> getDetailsOfOrder(String orderId);
    public List<OrderDto> getAllOrdersByUserId(String userId);

    public OrderDto getOrderByUserId(String userId);




}
