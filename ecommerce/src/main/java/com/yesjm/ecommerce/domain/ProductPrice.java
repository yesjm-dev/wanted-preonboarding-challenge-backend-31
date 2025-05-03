package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;

@Entity
public class ProductPrice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "base_price")
    private Double basePrice;
    @Column(name = "sale_price")
    private Double salePrice;
    @Column(name = "cost_price")
    private Double costPrice;
    private String currency;
    @Column(name = "tax_rate")
    private Double taxRate;
}