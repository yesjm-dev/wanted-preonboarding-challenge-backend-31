package com.yesjm.ecommerce.domain;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_details")
public class ProductDetail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double weight;
    @Column(columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode dimensions;
    private String materials;
    @Column(name = "country_of_origin")
    private String countryOfOrigin;
    @Column(name = "warranty_info")
    private String warrantyInfo;
    @Column(name = "care_instructions")
    private String careInstructions;
    @Column(name = "additional_info", columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode additionalInfo;

    @Setter
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Product product;

}