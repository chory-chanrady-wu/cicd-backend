package com.chanrady.backend.service;

import com.chanrady.backend.dto.UserRequestDTO;
import com.chanrady.backend.dto.UserResponseDTO;
import com.chanrady.backend.mapper.UserMapper;
import com.chanrady.backend.models.UserModel;
import com.chanrady.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::toResponseDTO).collect(Collectors.toList());
    }

    public UserResponseDTO getUserById(int id) {
        return userRepository.findById(id).map(UserMapper::toResponseDTO).orElse(null);
    }

    public UserResponseDTO createUser(UserRequestDTO dto) {
        UserModel user = UserMapper.toEntity(dto);
        user = userRepository.save(user);
        return UserMapper.toResponseDTO(user);
    }

    public UserResponseDTO updateUser(int id, UserRequestDTO dto) {
        return userRepository.findById(id).map(existing -> {
            existing.setFullname(dto.getFullname());
            existing.setEmail(dto.getEmail());
            existing.setPassword(dto.getPassword());
            return UserMapper.toResponseDTO(userRepository.save(existing));
        }).orElse(null);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
