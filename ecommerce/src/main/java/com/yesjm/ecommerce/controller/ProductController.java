package com.yesjm.ecommerce.controller;

import com.yesjm.ecommerce.dto.ResponseDto;
import com.yesjm.ecommerce.dto.request.ProductCreateRequest;
import com.yesjm.ecommerce.dto.response.ProductCreateResponse;
import com.yesjm.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseDto<ProductCreateResponse>> createProduct(@RequestBody ProductCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(productService.createProduct(request));
    }
}
