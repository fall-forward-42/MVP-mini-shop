package com.tdtu.lihitiShop.repository;

import com.tdtu.lihitiShop.entity.Product;
import com.tdtu.lihitiShop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
