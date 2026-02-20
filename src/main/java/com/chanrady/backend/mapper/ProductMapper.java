package com.chanrady.backend.mapper;

import com.chanrady.backend.dto.ProductRequestDTO;
import com.chanrady.backend.dto.ProductResponseDTO;
import com.chanrady.backend.models.ProductModel;
import com.chanrady.backend.models.CategoryModel;
import java.time.LocalDateTime;

public class ProductMapper {
    public static ProductModel toEntity(ProductRequestDTO dto, CategoryModel category) {
        ProductModel product = new ProductModel();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(category);
        product.setStock(dto.getStock());
        product.setPackaging(dto.getPackaging());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        product.setDeleted(false);
        return product;
    }

    public static ProductResponseDTO toResponseDTO(ProductModel product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCategoryId(product.getCategory() != null ? product.getCategory().getId() : 0);
        dto.setStock(product.getStock());
        dto.setPackaging(product.getPackaging());
        dto.setCreatedAt(product.getCreatedAt());
        dto.setUpdatedAt(product.getUpdatedAt());
        dto.setDeletedAt(product.getDeletedAt());
        dto.setDeleted(product.isDeleted());
        return dto;
    }
}
