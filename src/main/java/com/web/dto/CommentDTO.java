package com.web.dto;

import java.util.Date;

public class CommentDTO {

	private String email;
	private Integer blogId;
	private Date thoiGian;
	private String noiDung;

	public CommentDTO() {
	}

	public CommentDTO(String email, Integer blogId, Date thoiGian, String noiDung) {
		this.email = email;
		this.blogId = blogId;
		this.thoiGian = thoiGian;
		this.noiDung = noiDung;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getBlogId() {
		return blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
}
