package com.tdtu.lihitiShop.dto;

import com.tdtu.lihitiShop.entity.CartItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private String id_cart;
    private String id_user;
    private Date createdAt;
}
