package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_options")
public class ProductOption {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "additional_price")
    private BigDecimal additionalPrice;
    private String sku;
    private Integer stock;
    @Column(name = "display_order")
    private Integer displayOrder;

    @Setter
    @ManyToOne
    @JoinColumn(name = "option_group_id")
    private ProductOptionGroup optionGroup;
}
