package com.course.service;

import com.course.dto.CourseDto;
import com.course.dto.UserCreateDto;
import com.course.dto.UserDto;
import org.springframework.stereotype.Service;


public interface UserService {
   UserDto createUser(UserCreateDto createDto);
   UserDto getUserById(Long id);
}
