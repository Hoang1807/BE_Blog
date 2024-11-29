package com.web.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.dto.CommentDTO;
import com.web.service.CommentService;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin("*")
public class CommentController {
	@Autowired
	private CommentService commentService;

	@PostMapping("/add")
	public ResponseEntity<?> addComment(@RequestBody CommentDTO commentDTO) {
		Object result = commentService.addComment(commentDTO);
		if (result instanceof String) {
			return ResponseEntity.badRequest().body(result);
		}
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/blog/{blogId}")
    public ResponseEntity<?> findCommentsByBlogId(@PathVariable Integer blogId) {
        Object result = commentService.findCommentsByBlogId(blogId);
        if (result instanceof String) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
