package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rating;
    private String title;
    private String content;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "verified_purchase")
    private Boolean verifiedPurchase;
    @Column(name = "helpful_votes")
    private Integer helpfulVotes;

    @ManyToOne @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "user_id")
    private Long userId; // 유저 테이블이 없으므로 ID만 저장

}
