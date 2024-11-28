package com.web.service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.web.dto.BlogRequestDTO;
import com.web.dto.BlogResponseDTO;
import com.web.entity.Blog;
import com.web.entity.Users;
import com.web.repository.BlogRepository;
import com.web.repository.UsersRepository;
import com.web.utils.FileUtils;

import jakarta.transaction.Transactional;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Transactional
	public Object addBlog(BlogRequestDTO blogRequestDTO) {
		Optional<Users> existingUser = usersRepository.findById(blogRequestDTO.getEmail());
		if (existingUser.isEmpty()) {
			return "Người dùng không tồn tại.";
		}
		try {
			String url = FileUtils.writeFile(blogRequestDTO.getFile());
			Blog blog = new Blog(existingUser.get(), blogRequestDTO.getTieuDe(), blogRequestDTO.getNoiDung(), url,
					new Date());
			blog = blogRepository.save(blog);
			return new BlogResponseDTO(blog.getMa(), blog.getTieuDe(), blog.getNoiDung(), blog.getAnh());
		} catch (Exception e) {
			return "Kích thước file ảnh quá lớn.";
		}
	}

	public Object deleteBlog(Integer id) {
		Optional<Blog> blogOptional = blogRepository.findById(id);
		if (blogOptional.isEmpty()) {
			return "Bài viết không tồn tại.";
		}
		try {
			blogRepository.delete(blogOptional.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Object updateBlog(Integer id, BlogRequestDTO updatedBlog) {
		Optional<Blog> existingBlog = blogRepository.findById(id);
		if (existingBlog.isEmpty()) {
			return "Bài viết không tồn tại.";
		}

		Optional<Users> existingUser = usersRepository.findById(updatedBlog.getEmail());
		if (existingUser.isEmpty()) {
			return "Người dùng không tồn tại.";
		}
		try {
			String url = existingBlog.get().getAnh();
			if (Objects.nonNull(updatedBlog.getFile())) {
				if(Objects.nonNull(url)) {
					FileUtils.deleteFile(url);
				}
				url = FileUtils.writeFile(updatedBlog.getFile());
			}
			Blog blog = existingBlog.get();
			blog.setTieuDe(updatedBlog.getTieuDe());
			blog.setNoiDung(updatedBlog.getNoiDung());
			blog.setAnh(url);
			blog = blogRepository.save(blog);
			return new BlogResponseDTO(blog.getMa(), blog.getTieuDe(), blog.getNoiDung(), blog.getAnh());
		} catch (Exception e) {
			e.printStackTrace();
			return "Kích thước file ảnh quá lớn.";
		}
	}

	public Object findById(Integer id) {
		Optional<Blog> blogOptional = blogRepository.findById(id);
		if (blogOptional.isEmpty()) {
			return "Bài viết không tồn tại.";
		}
		return blogOptional.get();
	}

	public Object findByIdUser(String email) {
		Optional<Users> userOptional = usersRepository.findById(email);
		if (userOptional.isEmpty()) {
			return "Người dùng không tồn tại.";
		}
		return blogRepository.findByUsers_Email(email).stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	public Object findAll(int page) {
		return blogRepository.findAll(PageRequest.of(page, 7)).getContent().stream().map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	public Object findSizePage() {
		return blogRepository.findAll(PageRequest.of(0, 7)).getTotalPages();
	}

	private BlogResponseDTO convertToDTO(Blog blog) {
		BlogResponseDTO dto = new BlogResponseDTO();

		dto.setMa(blog.getMa());
		dto.setTieuDe(blog.getTieuDe());
		dto.setAnh(blog.getAnh());
		dto.setNoiDung(blog.getNoiDung());
		return dto;
	}
}
