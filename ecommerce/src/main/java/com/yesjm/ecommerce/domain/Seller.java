package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Seller {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "logo_url")
    private String logoUrl;
    private Double rating;
    @Column(name = "contact_email")
    private String contactEmail;
    @Column(name = "contact_phone")
    private String contactPhone;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
