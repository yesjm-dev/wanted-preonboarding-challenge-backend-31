package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;

@Entity
public class Brand {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private String description;
    @Column(name = "logo_url")
    private String logoUrl;
    private String website;
}
