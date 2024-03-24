package com.tdtu.lihitiShop.entity;

import com.tdtu.lihitiShop.entity.enumType.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id_order;

    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false,referencedColumnName = "id_user")
    private User user;

    @CreationTimestamp
    @Column(name = "order_date",nullable = false,updatable = false)
    private Date orderDate;

    @Column(name = "toltal_price", nullable = false)
    private Double toltalPrice;

    @Column(name = "address",nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private OrderStatus status;



}


