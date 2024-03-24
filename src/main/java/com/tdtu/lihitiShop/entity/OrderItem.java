package com.tdtu.lihitiShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem
{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id_order_item;

    @OneToOne
    @JoinColumn(name = "id_product",nullable = false,referencedColumnName = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_order",nullable = false,referencedColumnName = "id_order")
    private Order order;

    @Column(name = "quantity",nullable = false)
    private Integer quantity;

    @Column(name = "price",nullable = false)
    private Double price;
}
