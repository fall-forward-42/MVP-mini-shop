package com.tdtu.lihitiShop.repository;

import com.tdtu.lihitiShop.entity.OrderItem;
import com.tdtu.lihitiShop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItem, String> {
}
