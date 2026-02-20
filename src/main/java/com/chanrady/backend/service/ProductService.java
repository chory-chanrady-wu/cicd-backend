package com.chanrady.backend.service;

import com.chanrady.backend.dto.ProductRequestDTO;
import com.chanrady.backend.dto.ProductResponseDTO;
import com.chanrady.backend.mapper.ProductMapper;
import com.chanrady.backend.models.ProductModel;
import com.chanrady.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::toResponseDTO).collect(Collectors.toList());
    }

    public ProductResponseDTO getProductById(int id) {
        return productRepository.findById(id).map(ProductMapper::toResponseDTO).orElse(null);
    }

    public ProductResponseDTO createProduct(ProductRequestDTO dto) {
        ProductModel product = ProductMapper.toEntity(dto);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        product = productRepository.save(product);
        return ProductMapper.toResponseDTO(product);
    }

    public ProductResponseDTO updateProduct(int id, ProductRequestDTO dto) {
        return productRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setDescription(dto.getDescription());
            existing.setPrice(dto.getPrice());
            existing.setCategoryId(dto.getCategoryId());
            existing.setStock(dto.getStock());
            existing.setPackaging(dto.getPackaging());
            existing.setUpdatedAt(LocalDateTime.now());
            return ProductMapper.toResponseDTO(productRepository.save(existing));
        }).orElse(null);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}

