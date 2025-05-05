package com.yesjm.ecommerce.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yesjm.ecommerce.domain.*;
import com.yesjm.ecommerce.dto.ResponseDto;
import com.yesjm.ecommerce.dto.request.ProductCreateRequest;
import com.yesjm.ecommerce.dto.response.ProductCreateResponse;
import com.yesjm.ecommerce.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Transactional
    public ResponseDto<ProductCreateResponse> createProduct(ProductCreateRequest request) {
        // slug 중복 확인
        if (productRepository.existsBySlug(request.getSlug())) {
            throw new IllegalArgumentException("이미 사용 중인 상품 슬러그입니다.");
        }

        // 존재하는 셀러, 브랜드 확인
        Seller seller = sellerRepository.findById(request.getSellerId())
            .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 셀러 ID"));

        Brand brand = brandRepository.findById(request.getBrandId())
            .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 브랜드 ID"));

        // 상품 생성
        Product product = Product.builder()
            .name(request.getName())
            .slug(request.getSlug())
            .shortDescription(request.getShortDescription())
            .fullDescription(request.getFullDescription())
            .status(request.getStatus())
            .seller(seller)
            .brand(brand)
            .build();

        productRepository.save(product);

        // 가격, 상세, 카테고리 등 연관 엔티티 생성
        product.setDetail(ProductDetail.builder()
                              .product(product)
                              .weight(request.getDetail().getWeight())
                              .dimensions(objectMapper.valueToTree(request.getDetail().getDimensions()))
                              .materials(request.getDetail().getMaterials())
                              .countryOfOrigin(request.getDetail().getCountryOfOrigin())
                              .warrantyInfo(request.getDetail().getWarrantyInfo())
                              .careInstructions(request.getDetail().getCareInstructions())
                              .additionalInfo(objectMapper.valueToTree(request.getDetail().getAdditionalInfo()))
                              .build());

        product.setPrice(ProductPrice.builder()
                             .product(product)
                             .basePrice(request.getPrice().getBasePrice())
                             .salePrice(request.getPrice().getSalePrice())
                             .costPrice(request.getPrice().getCostPrice())
                             .currency(request.getPrice().getCurrency())
                             .taxRate(request.getPrice().getTaxRate())
                             .build());

        // 카테고리
        List<ProductCategory> categories = request.getCategories().stream().map(c -> {
            Category category =
                categoryRepository.findById(c.getCategoryId()).orElseThrow(() -> new IllegalArgumentException("카테고리 ID가 유효하지 않습니다."));
            return ProductCategory.builder()
                .category(category)
                .product(product)
                .isPrimary(c.getIsPrimary())
                .build();
        }).toList();
        product.setCategories(categories);

        // 태그
        List<ProductTag> productTags = request.getTags().stream().map(t -> {
            Tag tag = tagRepository.findById(t).orElseThrow(() -> new IllegalArgumentException("태그 ID가 유효하지 않습니다."));
            return ProductTag.builder()
                .tag(tag)
                .product(product)
                .build();
        }).collect(Collectors.toList());
        product.setTags(productTags);

        // 옵션 그룹 + 옵션
        List<ProductOptionGroup> optionGroups = request.getOptionGroupDtos().stream().map(og -> {
            List<ProductOption> options = og.getOptions().stream()
                .map(option -> {
                    return ProductOption.builder()
                        .name(option.getName())
                        .additionalPrice(option.getAdditionalPrice())
                        .sku(option.getSku())
                        .stock(option.getStock())
                        .displayOrder(option.getDisplayOrder())
                        .build();
                }).collect(Collectors.toList());

            ProductOptionGroup optionGroup = ProductOptionGroup.builder()
                .name(og.getName())
                .displayOrder(og.getDisplayOrder())
                .options(options)
                .product(product)
                .build();

            options.forEach(po -> po.setOptionGroup(optionGroup));

            return optionGroup;
        }).collect(Collectors.toList());
        product.setOptionGroups(optionGroups);

        // 이미지
        List<ProductImage> images = request.getImageDtos().stream()
            .map(i -> ProductImage.builder()
                .url(i.getUrl())
                .altText(i.getAltText())
                .displayOrder(i.getDisplayOrder())
                .isPrimary(i.getIsPrimary())
                .option(null)
                .build())
            .collect(Collectors.toList());
        product.setImages(images);

        return new ResponseDto<>(true, ProductCreateResponse.from(product), "상품이 성공적으로 등록되었습니다.");
    }

}
