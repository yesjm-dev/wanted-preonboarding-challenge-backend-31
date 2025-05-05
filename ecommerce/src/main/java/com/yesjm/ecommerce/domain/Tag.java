package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
}
