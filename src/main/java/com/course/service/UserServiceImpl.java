package com.course.service;

import com.course.dto.UserCreateDto;
import com.course.dto.UserDto;
import com.course.entites.User;
import com.course.mapper.UserMapper;
import com.course.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service

@Transactional
public  class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserCreateDto createDto) {
        if(userRepository.existsByEmail(createDto.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }
        User user=userMapper.toEntity(createDto);
        user.setCreatedAt(LocalDateTime.now());
        user.setRole("ROLE_USER");
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto getUserById(Long id) {
        return userRepository.findById(id).map(userMapper::toDto).orElseThrow(
                ()-> new EntityNotFoundException("User does not exists")
        );
    }

}
