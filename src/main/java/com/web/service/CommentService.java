package com.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dto.BlogResponseDTO;
import com.web.dto.CommentDTO;
import com.web.dto.CommentResponseDTO;
import com.web.entity.Blog;
import com.web.entity.Comment;
import com.web.entity.CommentId;
import com.web.entity.Users;
import com.web.repository.BlogRepository;
import com.web.repository.CommentRepository;
import com.web.repository.UsersRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private UsersRepository usersRepository;

	public Object addComment(CommentDTO commentDTO) {
		Optional<Blog> blogOptional = blogRepository.findById(commentDTO.getBlogId());
		if (blogOptional.isEmpty()) {
			return "Bài viết không tồn tại.";
		}
		Optional<Users> existingUser = usersRepository.findById(commentDTO.getEmail());
		if (existingUser.isEmpty()) {
			return "Người dùng không tồn tại.";
		}
		try {
			Comment comment = new Comment();
			comment.setBlog(blogOptional.get());
			comment.setUsers(existingUser.get());
			comment.setNoiDung(commentDTO.getNoiDung());
			comment.setThoiGian(new Date());

			comment = commentRepository.save(comment);
			return new CommentResponseDTO(comment.getUsers().getHoTen(), comment.getUsers().getAnh(),
					comment.getThoiGian(), comment.getNoiDung());
		} catch (Exception e) {
			return "Lỗi khi thêm bình luận: " + e.getMessage();
		}
	}

	public Object findCommentsByBlogId(Integer blogId) {
		Optional<Blog> blogOptional = blogRepository.findById(blogId);
		if (blogOptional.isEmpty()) {
			return "Bài viết không tồn tại.";
		}

		List<Comment> comments = commentRepository.findByBlog_Ma(blogId);
		return comments.isEmpty() ? "Không có bình luận nào."
				: comments.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	private CommentResponseDTO convertToDTO(Comment comment) {
		CommentResponseDTO dto = new CommentResponseDTO();

		dto.setHoTenNguoiComment(comment.getUsers().getHoTen());
		dto.setAnhNguoiComment(comment.getUsers().getAnh());
		dto.setThoiGian(comment.getThoiGian());
		dto.setNoiDung(comment.getNoiDung());
		return dto;
	}
}
