package com.web.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.dto.BlogRequestDTO;
import com.web.service.BlogService;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin("*")
public class BlogController {
	@Autowired
	private BlogService blogService;

	@PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> addBlog(@ModelAttribute BlogRequestDTO blogRequestDTO) {
		Object result = blogService.addBlog(blogRequestDTO);
		if (result instanceof String) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBlog(@PathVariable Integer id) {
		Object result = blogService.deleteBlog(id);
		if (result.equals(true)) {
			return ResponseEntity.ok("Xóa bài viết thành công.");
		}
		if (result.equals(false)) {
			return ResponseEntity.badRequest().body("Không thể xóa bài viết do ràng buộc dữ liệu.");
		}
		return ResponseEntity.badRequest().body(result);
	}

	@PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> updateBlog(@PathVariable Integer id, @ModelAttribute BlogRequestDTO updatedBlog) {
		Object result = blogService.updateBlog(id, updatedBlog);
		if (result instanceof String) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Object result = blogService.findById(id);
		if (result instanceof String) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@GetMapping("/user/{email}")
	public ResponseEntity<?> findByIdUser(@PathVariable String email) {
		Object result = blogService.findByIdUser(email);
		if (result instanceof String) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}

	@GetMapping
	public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page) {
		return ResponseEntity.ok(blogService.findAll(page));
	}

	@GetMapping("/size-page")
	public ResponseEntity<?> findSizePage() {
		return ResponseEntity.ok(blogService.findSizePage());
	}
}
