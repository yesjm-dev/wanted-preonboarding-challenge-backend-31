package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;

@Entity
public class ProductDetail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double weight;
    private String dimensions;
    private String materials;
    @Column(name = "country_of_origin")
    private String countryOfOrigin;
    @Column(name = "warranty_info")
    private String warrantyInfo;
    @Column(name = "care_instructions")
    private String careInstructions;
    @Column(name = "additional_info", columnDefinition = "TEXT")
    private String additionalInfo;

    @ManyToOne @JoinColumn(name = "product_id")
    private Product product;

}