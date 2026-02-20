package com.chanrady.backend.mapper;

import com.chanrady.backend.dto.UserRequestDTO;
import com.chanrady.backend.dto.UserResponseDTO;
import com.chanrady.backend.models.UserModel;

public class UserMapper {
    public static UserModel toEntity(UserRequestDTO dto) {
        UserModel user = new UserModel();
        user.setFullname(dto.getFullname());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    public static UserResponseDTO toResponseDTO(UserModel user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setFullname(user.getFullname());
        dto.setEmail(user.getEmail());
        return dto;
    }
}

