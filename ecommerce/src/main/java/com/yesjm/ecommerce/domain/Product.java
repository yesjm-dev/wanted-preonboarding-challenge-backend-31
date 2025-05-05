package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true, nullable = false)
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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private ProductDetail productDetail;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private ProductPrice productPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductCategory> productCategories;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductTag> productTags;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductOptionGroup> productOptionGroups;

    public void setDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
        productDetail.setProduct(this);
    }

    public void setPrice(ProductPrice productPrice) {
        this.productPrice = productPrice;
        productPrice.setProduct(this);
    }

    public void setCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    public void setTags(List<ProductTag> productTags) {
        this.productTags = productTags;
    }

    public void setOptionGroups(List<ProductOptionGroup> productOptionGroups) {
        this.productOptionGroups = productOptionGroups;
    }

    public void setImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }

}
