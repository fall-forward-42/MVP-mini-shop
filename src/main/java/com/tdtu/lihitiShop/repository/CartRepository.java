package com.tdtu.lihitiShop.repository;

import com.tdtu.lihitiShop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,String> {
}
