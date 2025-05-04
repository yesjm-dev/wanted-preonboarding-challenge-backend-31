package com.yesjm.ecommerce.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private String description;
    private Integer level;
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> children;
}