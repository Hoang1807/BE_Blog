package com.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CommentId {

	private String email;
	private int ma;

	public CommentId() {
	}

	public CommentId(String email, int ma) {
		this.email = email;
		this.ma = ma;
	}

	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ma", nullable = false)
	public int getMa() {
		return this.ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

}
