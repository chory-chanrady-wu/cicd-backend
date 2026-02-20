package com.chanrady.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProductResponseDTO {
    private int id;
    private String name;
    private String description;
    private double price;
    private int categoryId;
    private int stock;
    private String packaging;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private boolean deleted;
}

