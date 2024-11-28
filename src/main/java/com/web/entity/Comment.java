package com.web.entity;

import java.util.Date;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Comment")
public class Comment {

	private CommentId id;
	private Blog blog;
	private Users users;
	private Date thoiGian;
	private String noiDung;

	public Comment() {
	}

	public Comment(CommentId id, Blog blog, Users users, Date thoiGian, String noiDung) {
		this.id = id;
		this.blog = blog;
		this.users = users;
		this.thoiGian = thoiGian;
		this.noiDung = noiDung;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "email", column = @Column(name = "email", nullable = false, length = 50)),
			@AttributeOverride(name = "ma", column = @Column(name = "ma", nullable = false)) })
	public CommentId getId() {
		return this.id;
	}

	public void setId(CommentId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma", nullable = false, insertable = false, updatable = false)
	public Blog getBlog() {
		return this.blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email", nullable = false, insertable = false, updatable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "thoi_gian", nullable = false, length = 23)
	public Date getThoiGian() {
		return this.thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	@Column(name = "noi_dung", nullable = false)
	public String getNoiDung() {
		return this.noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

}
