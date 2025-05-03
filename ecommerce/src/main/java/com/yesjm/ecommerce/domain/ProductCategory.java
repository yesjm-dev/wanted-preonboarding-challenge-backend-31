package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;

@Entity
public class ProductCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne @JoinColumn(name = "category_id")
    private Category category;
    @Column(name = "is_primary")
    private Boolean isPrimary;
}
