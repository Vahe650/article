package com.post.article.service;


import com.post.article.dto.UserDto;

public interface UserService {

    UserDto findByUsername(String username);
}

