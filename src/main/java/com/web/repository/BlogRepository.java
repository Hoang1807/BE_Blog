package com.web.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
	List<Blog> findByUsers_Email(String email); // Tìm bài viết theo email user

	Page<Blog> findAll(Pageable pageable); // Phân trang
}
