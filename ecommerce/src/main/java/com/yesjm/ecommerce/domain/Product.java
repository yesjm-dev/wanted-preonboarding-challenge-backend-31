package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    @Column(name = "short_description")
    private String shortDescription;
    @Column(name = "full_description", columnDefinition = "TEXT")
    private String fullDescription;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private String status;

    @ManyToOne @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "product")
    private List<ProductDetail> productDetails;

    @OneToMany(mappedBy = "product")
    private List<ProductPrice> productPrices;

    @OneToMany(mappedBy = "product")
    private List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @OneToMany(mappedBy = "product")
    private List<ProductTag> productTags;

    @OneToMany(mappedBy = "product")
    private List<ProductOptionGroup> optionGroups;
}
