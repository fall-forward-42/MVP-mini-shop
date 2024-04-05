package com.tdtu.lihitiShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id_product;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    private String image;
    @Column(name = "price", nullable = false)
    private double price;
    @Column(name = "stock", nullable = false)
    private int stock;
    @Column(name = "expiry_date")
    private Date expiry_date ;
    @Column(name = "unit")
    private String unit; // Đơn vị bán hàng (ví dụ: kg, gói, thùng, hộp, ...)
    @Column(name = "brand")
    private String brand;
    @Column(name = "weight")
    private double weight;
    @Column(name = "origin")
    private String origin;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false,updatable = false)
    private  Date createdAt;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at", nullable = false)
    private  Date updatedAt;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cate")
    private Category category;

}
