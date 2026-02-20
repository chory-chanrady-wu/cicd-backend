package com.chanrady.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryRequestDTO {
    @NotNull
    private String name;
    private String description;
}

