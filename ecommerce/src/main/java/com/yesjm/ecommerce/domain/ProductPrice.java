package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
@Table(name = "product_prices")
public class ProductPrice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "base_price")
    private BigDecimal basePrice;
    @Column(name = "sale_price")
    private BigDecimal salePrice;
    @Column(name = "cost_price")
    private BigDecimal costPrice;
    private String currency;
    @Column(name = "tax_rate")
    private BigDecimal taxRate;

}