package com.spring.pagination.service.implementation;

import com.spring.pagination.domain.User;
import com.spring.pagination.repository.UserRepository;
import com.spring.pagination.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplementation.class);

    @Autowired
    private UserRepository userRepository;


    @Override
    public Page<User> getUsers(String name, int page, int size) {

        logger.info("Fetching users for page {} of size {}", page, size);

        return userRepository.findByNameContaining(name, PageRequest.of(page, size));
    }
}
