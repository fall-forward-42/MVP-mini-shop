package com.tdtu.lihitiShop.repository;

import com.tdtu.lihitiShop.entity.Order;
import com.tdtu.lihitiShop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
