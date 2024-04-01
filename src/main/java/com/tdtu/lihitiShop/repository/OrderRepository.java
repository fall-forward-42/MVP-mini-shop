package com.tdtu.lihitiShop.repository;

import com.tdtu.lihitiShop.entity.Order;
import com.tdtu.lihitiShop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, String> {
    @Query(value = "SELECT * FROM orders WHERE id_user = :id", nativeQuery = true)
    public Order findByUserId(@Param("id") String id);

}
