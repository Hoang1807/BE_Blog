package com.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.Comment;
import com.web.entity.CommentId;

public interface CommentRepository extends JpaRepository<Comment, CommentId> {
	List<Comment> findByBlog_Ma(Integer blogId);
}
