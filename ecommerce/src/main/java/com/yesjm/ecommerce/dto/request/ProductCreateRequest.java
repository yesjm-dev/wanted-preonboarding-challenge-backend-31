package com.yesjm.ecommerce.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class ProductCreateRequest {

    private String name;
    private String slug;
    private String shortDescription;
    private String fullDescription;
    private Long sellerId;
    private Long brandId;
    private String status;

    private Detail detail;
    private Price price;
    private List<CategoryDto> categories;
    private List<OptionGroupDto> optionGroupDtos;
    private List<ImageDto> imageDtos;
    private List<Long> tags;

    @Getter
    @Setter
    @Builder
    public static class Detail {
        private Double weight;
        private Dimensions dimensions;
        private String materials;
        private String countryOfOrigin;
        private String warrantyInfo;
        private String careInstructions;
        private AdditionalInfo additionalInfo;
    }

    @Getter
    @Setter
    @Builder
    public static class Dimensions {
        private Integer width;
        private Integer height;
        private Integer depth;
    }

    @Getter
    @Setter
    @Builder
    public static class AdditionalInfo {
        private Boolean assemblyRequired;
        private String assemblyTime;
    }

    @Getter
    @Setter
    @Builder
    public static class Price {
        private BigDecimal basePrice;
        private BigDecimal salePrice;
        private BigDecimal costPrice;
        private String currency;
        private BigDecimal taxRate;
    }

    @Getter
    @Setter
    @Builder
    public static class CategoryDto {
        private Long categoryId;
        private Boolean isPrimary;
    }

    @Getter
    @Setter
    @Builder
    public static class OptionGroupDto {
        private String name;
        private Integer displayOrder;
        private List<OptionDto> options;
    }

    @Getter
    @Setter
    @Builder
    public static class OptionDto {
        private String name;
        private BigDecimal additionalPrice;
        private String sku;
        private Integer stock;
        private Integer displayOrder;
    }

    @Getter
    @Setter
    @Builder
    public static class ImageDto {
        private String url;
        private String altText;
        private Boolean isPrimary;
        private Integer displayOrder;
        private Long optionId; // nullable
    }
}