package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ProductOptionGroup {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "display_order")
    private Integer displayOrder;

    @ManyToOne @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "optionGroup")
    private List<ProductOption> options;
}
