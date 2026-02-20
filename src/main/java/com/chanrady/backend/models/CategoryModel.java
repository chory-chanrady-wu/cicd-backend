package com.chanrady.backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table (name = "categories")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<ProductModel> products;
}
