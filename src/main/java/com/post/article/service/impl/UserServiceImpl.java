package com.post.article.service.impl;

import com.post.article.dto.UserDto;
import com.post.article.entity.User;
import com.post.article.mapper.UserEntityMapper;
import com.post.article.repository.UserRepository;
import com.post.article.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

    private final UserEntityMapper userEntityMapper;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserEntityMapper userEntityMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userEntityMapper = userEntityMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    void init() {
        UserDto admin = findByUsername("admin");
        if (admin == null) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setUserType(User.UserType.ADMIN);
            userRepository.save(user);
        }
    }

    @Override
    public UserDto findByUsername(String username) {
        return userEntityMapper.toDto(userRepository.findByUsername(username).orElse(null));
    }
}

