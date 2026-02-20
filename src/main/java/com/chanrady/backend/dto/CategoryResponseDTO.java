package com.chanrady.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CategoryResponseDTO {
    private int id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
}

