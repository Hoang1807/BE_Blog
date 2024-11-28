package com.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String>{

}
