package com.post.article.mapper;


import com.post.article.dto.UserDto;
import com.post.article.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper extends EntityMapper<UserDto, User> {
}
