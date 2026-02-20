package com.chanrady.backend.service;

import com.chanrady.backend.dto.CategoryRequestDTO;
import com.chanrady.backend.dto.CategoryResponseDTO;
import com.chanrady.backend.mapper.CategoryMapper;
import com.chanrady.backend.models.CategoryModel;
import com.chanrady.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryMapper::toResponseDTO).collect(Collectors.toList());
    }

    public CategoryResponseDTO getCategoryById(int id) {
        return categoryRepository.findById(id).map(CategoryMapper::toResponseDTO).orElse(null);
    }

    public CategoryResponseDTO createCategory(CategoryRequestDTO dto) {
        CategoryModel category = CategoryMapper.toEntity(dto);
        category.setCreationDate(LocalDateTime.now());
        category = categoryRepository.save(category);
        return CategoryMapper.toResponseDTO(category);
    }

    public CategoryResponseDTO updateCategory(int id, CategoryRequestDTO dto) {
        return categoryRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setDescription(dto.getDescription());
            return CategoryMapper.toResponseDTO(categoryRepository.save(existing));
        }).orElse(null);
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}

