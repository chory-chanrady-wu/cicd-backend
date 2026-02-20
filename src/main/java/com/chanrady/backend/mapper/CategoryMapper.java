package com.chanrady.backend.mapper;

import com.chanrady.backend.dto.CategoryRequestDTO;
import com.chanrady.backend.dto.CategoryResponseDTO;
import com.chanrady.backend.models.CategoryModel;

public class CategoryMapper {
    public static CategoryModel toEntity(CategoryRequestDTO dto) {
        CategoryModel category = new CategoryModel();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }

    public static CategoryResponseDTO toResponseDTO(CategoryModel category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setCreationDate(category.getCreationDate());
        return dto;
    }
}

