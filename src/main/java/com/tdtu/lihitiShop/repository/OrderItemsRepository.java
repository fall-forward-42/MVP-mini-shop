package com.tdtu.lihitiShop.repository;

import com.tdtu.lihitiShop.dto.OrderItemDto;
import com.tdtu.lihitiShop.entity.OrderItem;
import com.tdtu.lihitiShop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemsRepository extends JpaRepository<OrderItem, String> {
}
