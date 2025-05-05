package com.yesjm.ecommerce.dto.response;

import com.yesjm.ecommerce.domain.Product;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductCreateResponse {

    private Long id;
    private String name;
    private String slug;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ProductCreateResponse from(Product product) {
        return ProductCreateResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .slug(product.getSlug())
            .createdAt(product.getCreatedAt())
            .updatedAt(product.getUpdatedAt())
            .build();
    }

}