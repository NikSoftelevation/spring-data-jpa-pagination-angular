package com.spring.pagination.repository;

import com.spring.pagination.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    Page<User> findByNameContaining(String name, Pageable pageable);
}