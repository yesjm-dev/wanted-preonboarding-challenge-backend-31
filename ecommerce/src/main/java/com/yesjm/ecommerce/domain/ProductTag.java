package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;

@Entity
public class ProductTag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne @JoinColumn(name = "tag_id")
    private Tag tag;
}