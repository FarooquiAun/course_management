package com.course.mapper;

import com.course.dto.UserCreateDto;
import com.course.dto.UserDto;
import com.course.entites.User;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface UserMapper {


    UserDto toDto(User user);

    User toEntity(UserCreateDto createDto);
}
