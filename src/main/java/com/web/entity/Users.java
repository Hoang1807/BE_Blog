package com.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@ToString
@Table(name = "Users")
public class Users {

	private String email;
	private String hoTen;
	private String matKhau;
	private String anh;

	public Users() {
	}

	public Users(String email, String hoTen, String matKhau) {
		this.email = email;
		this.hoTen = hoTen;
		this.matKhau = matKhau;
	}

	public Users(String email, String hoTen, String matKhau, String anh) {
		this.email = email;
		this.hoTen = hoTen;
		this.matKhau = matKhau;
		this.anh = anh;
	}

	@Id

	@Column(name = "email", unique = true, nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ho_ten", nullable = false)
	public String getHoTen() {
		return this.hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	@Column(name = "mat_khau", nullable = false)
	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Column(name = "anh")
	public String getAnh() {
		return this.anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

}
