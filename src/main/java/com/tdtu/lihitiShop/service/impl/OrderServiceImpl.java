package com.tdtu.lihitiShop.service.impl;

import com.tdtu.lihitiShop.dto.OrderDto;
import com.tdtu.lihitiShop.dto.OrderItemDto;
import com.tdtu.lihitiShop.dto.ProductDto;
import com.tdtu.lihitiShop.entity.Order;
import com.tdtu.lihitiShop.entity.Product;
import com.tdtu.lihitiShop.mapper.OrderItemMapper;
import com.tdtu.lihitiShop.mapper.OrderMapper;
import com.tdtu.lihitiShop.mapper.ProductMapper;
import com.tdtu.lihitiShop.repository.OrderItemsRepository;
import com.tdtu.lihitiShop.repository.OrderRepository;
import com.tdtu.lihitiShop.repository.ProductRepository;
import com.tdtu.lihitiShop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class
OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private OrderItemsRepository orderItemsRepository;
    private ProductRepository productRepository;

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

    @Override
    public List<OrderItemDto> getDetailsOfOrder(String orderId) {
        List<OrderItemDto> items = orderItemsRepository.findAll().stream()
                .filter(e->e.getOrder().getId_order().equals(orderId))
                .map(e->{
                            Product product =  productRepository.findById(e.getId_product()).get();
                            OrderItemDto result = OrderItemMapper.mapToDtoWithProduct(e, ProductMapper.mapToProductDto(product));
                            return result;
                        }
                        )
                .toList();

        return items;
    }

    @Override
    public List<OrderDto> getAllOrdersByUserId(String userId) {
        List<OrderDto> items = orderRepository.findAll().stream()
                .filter(e->e.getUser().getId_user().equals(userId))
                .map(OrderMapper::mapToDto).toList();
        return items;
    }

    @Override
    public OrderDto getOrderByUserId(String userId) {
        Order order = orderRepository.findByUserId(userId);
        return OrderMapper.mapToDto(order);
    }
}
