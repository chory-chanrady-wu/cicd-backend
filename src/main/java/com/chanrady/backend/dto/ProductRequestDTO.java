package com.chanrady.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ProductRequestDTO {
    @NotBlank
    private String name;
    private String description;
    @NotNull
    private Double price;
    @NotNull
    private Integer categoryId;
    @NotNull
    private Integer stock;
    private String packaging;
}

