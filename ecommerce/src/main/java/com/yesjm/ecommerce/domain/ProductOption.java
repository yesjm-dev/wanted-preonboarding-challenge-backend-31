package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;

@Entity
public class ProductOption {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "additional_price")
    private Double additionalPrice;
    private String sku;
    private Integer stock;
    @Column(name = "display_order")
    private Integer displayOrder;

    @ManyToOne @JoinColumn(name = "option_group_id")
    private ProductOptionGroup optionGroup;
}
