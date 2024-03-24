package com.tdtu.lihitiShop.repository;

import com.tdtu.lihitiShop.entity.CartItem;
import com.tdtu.lihitiShop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemsRepository extends JpaRepository<CartItem, String> {
}
