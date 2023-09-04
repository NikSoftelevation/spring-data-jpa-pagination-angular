package com.spring.pagination.service;

import com.spring.pagination.domain.User;
import org.springframework.data.domain.Page;

public interface UserService {

    Page<User> getUsers(String name,int page,int size);
}