package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;

@Entity
public class ProductImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @Column(name = "alt_text")
    private String altText;
    @Column(name = "is_primary")
    private Boolean isPrimary;
    @Column(name = "display_order")
    private Integer displayOrder;

    @ManyToOne @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne @JoinColumn(name = "option_id")
    private ProductOption option;
}
